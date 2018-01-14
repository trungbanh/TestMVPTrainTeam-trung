package com.example.haudo.testmvptrainteam.Data.Respository;

import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.example.haudo.testmvptrainteam.Data.Database.AccountDao;
import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by HauDo on 1/11/2018.
 */

public class AccountDataSourceExecute extends AccountDataSource {

    private static AccountDataSourceExecute INSTANCE = null;
    private Executor mExecutor;

    private AccountDao mAccountDao;

    private AccountDataSourceExecute(AccountDao accountDao) {
        mExecutor = Executors.newFixedThreadPool(3);
        this.mAccountDao = accountDao;
    }

    public static AccountDataSourceExecute getInstance(AccountDao accountDao) {
        if (INSTANCE == null) {
            INSTANCE = new AccountDataSourceExecute(accountDao);
        }
        return INSTANCE;
    }

    @Override
    public void insert(final AccountObject accountObject, final AccountCallback callback) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    long value = mAccountDao.insert(accountObject);
                    callback.onAccountInsert(value);
                } catch (SQLiteConstraintException exception) {
                    callback.onError("Lỗi insert!");
                }
            }
        });
    }
    @Override
    public void getAccount(final String user, final AccountCallback callback) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                AccountObject accountObject = mAccountDao.getAccount(user);
                if (null != accountObject) {
                    callback.onAccountLoaded(accountObject);
                }
            }
        });
    }
    @Override
    void checkAccount(final AccountObject accountObject, final AccountCallback callback) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (accountObject == mAccountDao.getAccount(accountObject.getUser().toString())){
                    callback.onAccountLoaded(accountObject);
                }
            }
        });
    }

}
