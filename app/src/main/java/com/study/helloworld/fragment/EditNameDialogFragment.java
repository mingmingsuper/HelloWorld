package com.study.helloworld.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.study.helloworld.R;

/**
 * Created by liumingming on 2017/8/21.
 */

public class EditNameDialogFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(true);
        }
        View view = inflater.inflate(R.layout.fragment_edit_name,container);
        return view;
    }
}
