package com.example.haudo.testmvptrainteam.Register;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by HauDo on 1/11/2018.
 */

public interface RegisterContract {

    interface View {
        void setPresenter(Presenter presenter);

        void showSuccess(String message);

        void showError(String message);

        void checkAccountSuccess(AccountObject account);
    }

    interface Presenter {

        void insert(AccountObject accountObject);

        void checkPassword(String passWord, String confirmPassword, AccountObject accountObject);

    }
}
