package com.example.haudo.testmvptrainteam.Register;

import android.util.Log;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountCallback;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountRepository;
import com.example.haudo.testmvptrainteam.Login.LoginFragment;

/**
 * Created by HauDo on 1/11/2018.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private AccountRepository mRepository;
    private RegisterContract.View mView;

    public RegisterPresenter(AccountRepository accountRepository, RegisterFragment view) {
        this.mRepository = accountRepository;
        this.mView = view;
        mView.setPresenter(this);
    }
    @Override
    public void insert(AccountObject accountObject) {
        mRepository.insert(accountObject, new AccountCallback() {
            @Override
            public void onAccountInsert(long value) {
                super.onAccountInsert(value);
                Log.e("logg", "insert value " + value);
                mView.showSuccess("Đăng ký thành công");
            }
            @Override
            public void onError(String error) {
                super.onError(error);
                mView.showError("Tài khoản đã tồn tại");
            }
        });
    }

    @Override
    public void checkPassword(String passWord, String confirmPassword, AccountObject account) {
        if (passWord.equals(confirmPassword)) {
            mView.checkAccountSuccess(account);
        } else {
            mView.showError("Mật khẩu không khớp");
        }
    }
}
