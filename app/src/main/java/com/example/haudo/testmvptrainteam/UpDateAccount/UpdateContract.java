package com.example.haudo.testmvptrainteam.UpDateAccount;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by banhtrung on 1/16/2018.
 */

public interface UpdateContract {
    interface Presenter {
        void updateAccount (AccountObject accountObject) ;

    }
    interface View {
        void sucess () ;

        void fail () ;

        void setPresenter (Presenter presenter);
    }
}
