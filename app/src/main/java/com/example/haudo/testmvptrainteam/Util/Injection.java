package com.example.haudo.testmvptrainteam.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.haudo.testmvptrainteam.Data.Respository.AccountDataSourceExecute;
import com.example.haudo.testmvptrainteam.Data.Database.AccountDatabase;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountRepository;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by HauDo on 1/3/2018.
 */

public class Injection {
    @SuppressLint("RestrictedApi")
    public static AccountRepository provideTasksRepository(@NonNull Context context) {
        checkNotNull(context);
        AccountDatabase database = AccountDatabase.getInstance(context);
        return AccountRepository.getInstance(AccountDataSourceExecute.getInstance(database.accountDao()));
    }
}
