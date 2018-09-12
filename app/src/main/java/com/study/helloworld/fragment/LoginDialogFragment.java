package com.study.helloworld.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.study.helloworld.R;

/**
 * Created by liumingming on 2017/8/22.
 */

public class LoginDialogFragment extends DialogFragment {

    private EditText mUserName;
    private EditText mPassword;
    public  LoginInputListener mListener;

    public interface LoginInputListener
    {
        void onLoginInputComplete(String username,String password);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_login_dialog,null);
        mUserName = (EditText)view.findViewById(R.id.txt_user_name);
        mPassword = (EditText)view.findViewById(R.id.txt_user_password);
        builder.setView(view).setPositiveButton("登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (mListener != null) {
                    Log.i("callback","================================");
                    mListener.onLoginInputComplete(mUserName.getText().toString(),mPassword.getText().toString());
                }
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return  builder.create();
    }
}
