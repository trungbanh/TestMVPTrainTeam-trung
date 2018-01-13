package com.example.haudo.testmvptrainteam.Data.Object;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by HauDo on 1/11/2018.
 */

@Entity(tableName = "Account")
public class AccountObject {

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "user")
    private String mUser;

    @ColumnInfo(name = "password")
    private String mPassword;

    public AccountObject(String mUser, String mPassword) {
        this.mUser = mUser;
        this.mPassword = mPassword;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String mUser) {
        this.mUser = mUser;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    @Override
    public String toString() {
        return "user " + mUser + " pass " + mPassword;
    }
}
