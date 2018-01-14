package com.example.haudo.testmvptrainteam.Login;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by banhtrung on 1/12/2018.
 */

public interface LoginContract {
    interface Presenter {

        void checkAccount(AccountObject accountObject);

        boolean isSucess();

        void moveFrament () ;
    }
    interface View {

        void setPresenter (Presenter presenter) ;

        void showSucess();

        void showFail();

        void move2register ();
    }
}
