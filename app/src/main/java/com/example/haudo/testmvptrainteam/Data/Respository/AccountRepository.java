package com.example.haudo.testmvptrainteam.Data.Respository;

import android.widget.Toast;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by HauDo on 1/11/2018.
 */

public class AccountRepository extends AccountDataSource {

    private static AccountRepository INSTANCE;

    private AccountDataSource mData;

    private AccountRepository(AccountDataSource accountDataSource) {
        this.mData = accountDataSource;
    }

    public static AccountRepository getInstance(AccountDataSource accountDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new AccountRepository(accountDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void insert(AccountObject accountObject, final AccountCallback callback) {
        mData.insert(accountObject, new AccountCallback() {

            @Override
            public void onAccountInsert(long value) {
                callback.onAccountInsert(value);
            }

            @Override
            public void onError(String error) {
                super.onError(error);
                callback.onError(error);
            }
        });
    }
    @Override
    public void getAccount(String user, final AccountCallback callback) {
        mData.getAccount(user, new AccountCallback() {
            @Override
            public void onAccountLoaded(AccountObject accountObject) {
                callback.onAccountLoaded(accountObject);
            }
        });
    }

    @Override
    public void checkAccount(AccountObject accountObject, final AccountCallback callback) {
        mData.checkAccount(accountObject, new AccountCallback() {
            @Override
            public void onAccountLoaded(AccountObject accountObject) {
                super.onAccountLoaded(accountObject);
            }
        });
    }

    @Override
    public void update(AccountObject accountObject, final AccountCallback callback) {
        mData.update(accountObject, new AccountCallback() {
            @Override
            public void onAccountUpdate(long value) {
                super.onAccountUpdate(value);
                callback.onAccountUpdate(value);
            }

            @Override
            public void onError(String error) {
                super.onError(error);
            }
        });
    }


}
