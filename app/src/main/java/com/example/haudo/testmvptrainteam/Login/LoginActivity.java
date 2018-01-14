package com.example.haudo.testmvptrainteam.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.haudo.testmvptrainteam.R;
import com.example.haudo.testmvptrainteam.Util.ActivityUtil;
import com.example.haudo.testmvptrainteam.Util.Injection;


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
        LoginPresenter registerPresenter = new LoginPresenter(Injection
                .provideTasksRepository(getApplicationContext()), costFragment);
    }
}
