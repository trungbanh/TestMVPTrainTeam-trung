package com.example.haudo.testmvptrainteam.Register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.haudo.testmvptrainteam.Login.LoginPresenter;
import com.example.haudo.testmvptrainteam.R;
import com.example.haudo.testmvptrainteam.Util.ActivityUtil;
import com.example.haudo.testmvptrainteam.Util.Injection;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupToolbar();
        setupFragment();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupFragment() {
        RegisterFragment costFragment = (RegisterFragment) getSupportFragmentManager()
                .findFragmentById(R.id.container);
        if (costFragment == null) {
            costFragment = RegisterFragment.newInstance();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), costFragment, R.id.container);
        }
        RegisterPresenter registerPresenter = new RegisterPresenter(Injection
                .provideTasksRepository(getApplicationContext()), costFragment);
    }
}
