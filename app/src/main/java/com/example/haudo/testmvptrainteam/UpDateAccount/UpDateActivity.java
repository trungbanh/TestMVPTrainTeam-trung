package com.example.haudo.testmvptrainteam.UpDateAccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.haudo.testmvptrainteam.R;
import com.example.haudo.testmvptrainteam.Util.ActivityUtil;
import com.example.haudo.testmvptrainteam.Util.Injection;

public class UpDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date);


        setupFragment();
    }

    private void setupFragment() {
        UpDateFragment costFragment = (UpDateFragment) getSupportFragmentManager()
                .findFragmentById(R.id.containerUpdate);
        if (costFragment == null) {
            costFragment = UpDateFragment.newInstance();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), costFragment, R.id.containerUpdate);
        }
        UpdatePresenter registerPresenter = new UpdatePresenter(Injection
                .provideTasksRepository(getApplicationContext()), costFragment);
    }

}
