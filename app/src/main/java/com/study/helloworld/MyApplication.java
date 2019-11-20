package com.study.helloworld;

import android.app.Application;
import android.content.pm.ActivityInfo;

import com.hhmedic.android.rescue.HHRescueDoctor;
import com.hhmedic.android.sdk.config.DeviceType;
import com.hhmedic.android.sdk.config.HHSDKOptions;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HHSDKOptions options = HHSDKOptions.defaultSoundOption("8273");

        options.isDebug = true;

        options.dev = true;

        options.mDeviceType = DeviceType.NORMAL;

        options.isOpenCamera = true;

        options.isOpenEvaluation = true;

        options.mOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        HHRescueDoctor.init(getApplicationContext(), options);
    }
}
