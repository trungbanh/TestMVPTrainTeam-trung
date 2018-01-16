package com.example.haudo.testmvptrainteam.Data.Respository;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by HauDo on 1/11/2018.
 */

public abstract class AccountDataSource {

    abstract void insert(AccountObject accountObject, AccountCallback callback);

    abstract void getAccount(String user, AccountCallback callback);

    abstract void checkAccount (AccountObject accountObject , AccountCallback callback);

    abstract void update (AccountObject accountObject ,AccountCallback callback) ;
}
