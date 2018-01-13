package com.example.haudo.testmvptrainteam.Data.Respository;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by HauDo on 1/11/2018.
 */

public abstract class AccountCallback {

    public void onAccountLoaded(AccountObject accountObject) {

    }

    public void onAccountInsert(long value) {

    }

    public void onAccountDelete(long value) {

    }

    public void onAccountUpdate(long value) {

    }

    public void onError(String error){

    }

}
