package com.example.haudo.testmvptrainteam.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haudo.testmvptrainteam.R;

/**
 * Created by HauDo on 1/11/2018.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    private View mView;

    private EditText mUser;

    private EditText mPassword;

    private Button mLogin;

    LoginPresenter presenter ;


    public static LoginFragment newInstance() {
        return new LoginFragment() ;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, container, false);

        mUser = mView.findViewById(R.id.edtUser);
        mPassword = mView.findViewById(R.id.edtPass);
        mLogin = mView.findViewById(R.id.btnLogin);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.checkAccount(mUser.getText().toString(),mPassword.getText().toString());
            }
        });

        return mView;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = (LoginPresenter) presenter;
    }

    @Override
    public void showSucess() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),"okey chua",Toast.LENGTH_SHORT).show();
            }
        });

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

}
