package com.example.haudo.testmvptrainteam.Login;

import android.util.Log;

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
        Log.i("log","set presenter");
    }

    @Override
    public void checkAccount(final AccountObject accountObject1) {

        mRepository.getAccount(accountObject1.getUser(), new AccountCallback() {
            @Override
            public void onAccountLoaded(AccountObject accountObject) {
                super.onAccountLoaded(accountObject);

                if (accountObject1.getPassword().equals(accountObject.getPassword())){
                    mView.showSucess();
                }else {
                    mView.showFail();
                }
            }

            @Override
            public void onError(String error) {
                super.onError(error);

                mView.showFail();
            }
        });

    }
    @Override
    public boolean isSucess() {
        return false;
    }

    @Override
    public void moveFrament() {
        mView.move2register();
    }
}
