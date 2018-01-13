package com.example.haudo.testmvptrainteam.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haudo.testmvptrainteam.Data.Object.AccountObject;
import com.example.haudo.testmvptrainteam.Login.LoginActivity;
import com.example.haudo.testmvptrainteam.R;

/**
 * Created by HauDo on 1/11/2018.
 */

public class RegisterFragment extends Fragment implements RegisterContract.View,
        View.OnClickListener {

    private RegisterContract.Presenter mPresenter;

    private View mView;

    private EditText mUser;

    private EditText mPassword;

    private EditText mConfirmPassword;

    private Button mRegister;


    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_register, container, false);

        mUser = mView.findViewById(R.id.edtUser);
        mPassword = mView.findViewById(R.id.edtPass);
        mConfirmPassword = mView.findViewById(R.id.edtConfirmPassword);
        mRegister = mView.findViewById(R.id.btnRegister);

        mRegister.setOnClickListener(this);
        return mView;
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showSuccess(String message) {
        showMessage(message);
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String message) {
        showMessage(message);
    }

    @Override
    public void checkAccountSuccess(AccountObject account) {
        mPresenter.insert(account);
    }

    //click to check password if password is correct do register account
    @Override
    public void onClick(View view) {
        String user = mUser.getText().toString();
        String pass = mPassword.getText().toString();
        String confirm = mConfirmPassword.getText().toString();

        mPresenter.checkPassword(pass, confirm, new AccountObject(user, pass));
    }

    private void showMessage(final String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
