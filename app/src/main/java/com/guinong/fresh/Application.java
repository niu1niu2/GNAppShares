package com.guinong.fresh;

import android.support.multidex.MultiDexApplication;

import com.guinong.lib_commom.api.guinong.ApiClient;

public class Application extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ApiClient.contextInit(this);
    }
}
