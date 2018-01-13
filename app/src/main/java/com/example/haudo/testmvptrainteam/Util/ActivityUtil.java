package com.example.haudo.testmvptrainteam.Util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by HauDo on 1/2/2018.
 */

public class ActivityUtil {

    public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment,
                                             int idFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(idFragment, fragment);
        transaction.commit();
    }
}
