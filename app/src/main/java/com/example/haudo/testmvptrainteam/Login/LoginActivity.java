package com.example.haudo.testmvptrainteam.Login;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.haudo.testmvptrainteam.Data.Database.AccountDatabase;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountDataSourceExecute;
import com.example.haudo.testmvptrainteam.Data.Respository.AccountRepository;
import com.example.haudo.testmvptrainteam.R;
import com.example.haudo.testmvptrainteam.Register.RegisterFragment;
import com.example.haudo.testmvptrainteam.Register.RegisterPresenter;
import com.example.haudo.testmvptrainteam.Util.ActivityUtil;
import com.example.haudo.testmvptrainteam.Util.Injection;

import static android.support.v4.util.Preconditions.checkNotNull;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupFragment();


    }
    private void setupFragment() {
        LoginFragment costFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.container);
        if (costFragment == null) {
            costFragment = LoginFragment.newInstance();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), costFragment, R.id.container);
        }
        LoginPresenter registerPresenter = new LoginPresenter(Injection.provideTasksRepository(getApplicationContext()),
                costFragment);

    }
}
