package com.guinong.net.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * @author chenshuangniu
 * @time 2016/5/31 22:02
 * @内容 sharedPreference工具 可以不使用 但可以创建
 * @版本
 */
public class SharedPreferencesUtils {
    public static final String KEY = "coolbuy.spkey";
    public static final String TOKEN = "token";
    private static SharedPreferencesUtils mInstance;
    private static Context mContext;
    private SharedPreferences mPerference;
    private SharedPreferences.Editor mEditor;

    private SharedPreferencesUtils(Context context) {
        this.mContext = context;
    }

    public static synchronized SharedPreferencesUtils getInstance(Context context) {//单例
        if (mInstance == null) {
            mInstance = new SharedPreferencesUtils(context);
        }
        return mInstance;
    }

    /**
     * 保存token 这里是由于
     *
     * @param token
     */
    public void saveToken(String token) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        sp.edit().putString(TOKEN, token).commit();
    }

    /**
     * 获得token
     *
     * @return
     */
    public String getToken() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_APPEND);
        String s = sp.getString(TOKEN, "");
        return s;
    }
}
