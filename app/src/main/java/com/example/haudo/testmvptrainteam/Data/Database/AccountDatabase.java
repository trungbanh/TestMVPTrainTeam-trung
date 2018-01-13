package com.example.haudo.testmvptrainteam.Data.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;

/**
 * Created by HauDo on 1/11/2018.
 */

@Database(entities = AccountObject.class, version = 1)
public abstract class AccountDatabase extends RoomDatabase {

    private static AccountDatabase INSTANCE;

    public abstract AccountDao accountDao();

    public static AccountDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AccountDatabase.class, "Account.db").build();
        }
        return INSTANCE;
    }
}
