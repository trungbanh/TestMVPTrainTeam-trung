package com.example.haudo.testmvptrainteam.UpDateAccount;

import android.content.Intent;
import android.os.Bundle;
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


public class UpDateFragment extends Fragment implements UpdateContract.View {

    private UpdateContract.Presenter mPresenter;

    private View mView;

    private EditText mUser;

    private EditText mPassword;

    private Button mUpdate;


    public UpDateFragment() {
        // Required empty public constructor
    }
    public static UpDateFragment newInstance() {
        return new UpDateFragment() ;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_up_date, container, false);

        mUser = v.findViewById(R.id.edtUserUpdate);
        mPassword = v.findViewById(R.id.edtPassUpdate) ;
        mUpdate = v.findViewById(R.id.btnUpdate);

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = mUser.getText().toString();
                String p = mPassword.getText().toString();
                mPresenter.updateAccount(new AccountObject(u,p));
            }
        });

        return v;
    }

    @Override
    public void sucess() {
        Intent intent = new Intent(getContext(), LoginActivity.class) ;
        startActivity(intent);
    }

    @Override
    public void fail() {
        Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(UpdateContract.Presenter presenter) {
        this.mPresenter = presenter ;
    }
}
