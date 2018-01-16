package com.example.haudo.testmvptrainteam.UpDateAccount;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountCallback;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountRepository;


/**
 * Created by banhtrung on 1/16/2018.
 */

public class UpdatePresenter implements UpdateContract.Presenter {


    private AccountRepository mRepository;
    private UpdateContract.View mView;


    public UpdatePresenter(AccountRepository accountRepository, UpDateFragment view) {
        this.mRepository = accountRepository;
        this.mView = view;
        mView.setPresenter(this);
    }
    @Override
    public void updateAccount(AccountObject accountObject) {
        mRepository.update(accountObject, new AccountCallback() {
            @Override
            public void onAccountUpdate(long value) {
                super.onAccountUpdate(value);
                mView.sucess();
            }
            @Override
            public void onError(String error) {
                super.onError(error);
            }
        });
    }
}
