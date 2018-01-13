package com.example.haudo.testmvptrainteam.Login;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountCallback;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountRepository;

/**
 * Created by banhtrung on 1/12/2018.
 */

public class LoginPresenter implements LoginContract.Presenter {


    private AccountRepository mRepository ;
    private LoginContract.View  mView;


    public LoginPresenter(AccountRepository accountRepository, LoginFragment costFragment) {
        mRepository = accountRepository ;
        mView = costFragment ;
        mView.setPresenter(this);
    }

    @Override
    public void checkAccount(final String user , final String pass) {
        mRepository.getAccount(user, new AccountCallback() {
            @Override
            public void onAccountLoaded(AccountObject accountObject) {
                super.onAccountLoaded(accountObject);
                AccountObject accountObject1 = new AccountObject(user,pass) ;

                if (accountObject1 == accountObject) {
                    mView.showSucess();
                } else {
                    mView.showFail();
                }

            }
        });
    }

    @Override
    public boolean isSucess() {
        return false;
    }
}
