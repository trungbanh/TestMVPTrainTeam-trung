package com.example.haudo.testmvptrainteam.Data.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by HauDo on 1/11/2018.
 */

@Dao
public interface AccountDao {

    @Query("SELECT * FROM Account WHERE user = :user")
    AccountObject getAccount(String user);

    @Insert
    long insert(AccountObject accountObject);

    @Update
    void update(AccountObject accountObject);

    @Query("UPDATE Account SET user = :user, password = :password")
    void update(String user, String password);

    @Delete
    void delete(AccountObject accountObject);

}
