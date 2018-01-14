package com.example.haudo.testmvptrainteam.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;
import com.example.haudo.testmvptrainteam.R;
import com.example.haudo.testmvptrainteam.Register.RegisterActivity;
import com.example.haudo.testmvptrainteam.Register.RegisterFragment;

/**
 * Created by HauDo on 1/11/2018.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    private View mView;

    private EditText mUser;

    private EditText mPassword;

    private TextView mRegister ;

    private Button mLogin;

    LoginContract.Presenter presenter ;

    public static LoginFragment newInstance() {
        return new LoginFragment() ;
    }

    public LoginFragment () {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, container, false);

        mUser = mView.findViewById(R.id.edtUser);
        mPassword = mView.findViewById(R.id.edtPass);
        mLogin = mView.findViewById(R.id.btnLogin);
        mRegister = mView.findViewById(R.id.tv_Register);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.moveFrament();
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =mUser.getText().toString() ;
                String pass = mPassword.getText().toString();
                Log.i("log","onlick Login fragment") ;
                presenter.checkAccount(new AccountObject(name,pass));
            }
        });
        return mView;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter =  presenter;
    }

    @Override
    public void showSucess() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),"okey chua",Toast.LENGTH_SHORT).show();
            }
        });
        Log.i("logg","suces");
    }
    @Override
    public void showFail() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),"fail ne",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void move2register() {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
    }
}
