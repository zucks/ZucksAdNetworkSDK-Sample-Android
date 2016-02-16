package net.zucks.zucksadnetworksdk.sample.android;

import android.app.Application;

import net.zucks.util.ZucksLog;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // デバッグログを表示する
        ZucksLog.show();
    }
}
