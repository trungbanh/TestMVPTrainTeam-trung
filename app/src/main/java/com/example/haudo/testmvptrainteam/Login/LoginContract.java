package com.example.haudo.testmvptrainteam.Login;

/**
 * Created by banhtrung on 1/12/2018.
 */

public interface LoginContract {
    interface Presenter {

        void checkAccount(String user ,String pass);

        boolean isSucess();
    }
    interface View {

        void setPresenter (Presenter presenter) ;

        void showSucess();

        void showFail();
    }
}
