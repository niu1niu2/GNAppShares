package com.guinong.lib_commom.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guinong.lib_commom.GNCommonApplication;
import com.guinong.lib_commom.constant.FinalConstant;
import com.guinong.lib_utils.Constant;
import com.guinong.lib_utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenshuangniu
 * @time 2016/5/31 22:02
 * @内容 sharedPreference工具 可以不使用 但可以创建
 * @版本
 */
public class SharedPreferencesUtils {
    public static final String KEY = "coolbuy.spkey";
    private static SharedPreferencesUtils mInstance;
    private static Context mContext;
    private SharedPreferences mPerference;
    private SharedPreferences.Editor mEditor;

    private SharedPreferencesUtils(Context context) {
        this.mContext = context;
    }

    public static synchronized SharedPreferencesUtils getInstance() {//单例
        if (mInstance == null) {
            mInstance = new SharedPreferencesUtils(GNCommonApplication.getApplicaContext());
        }
        return mInstance;
    }

    /**
     * 是否登录过
     *
     * @return
     */
    public Boolean getLoginStatus() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getBoolean(FinalConstant.is_login, false);
    }

    /**
     * 是否第一次打开app
     *
     * @return
     */
    public Boolean getFristOpen() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getBoolean(FinalConstant.isFristOpen, true);
    }

    /**
     * 获取双十一活动id
     *
     * @return
     */
    public String getSpecialActiveId() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getString(FinalConstant.specialActiveId, "");
    }

    /**
     * 获取双十一活动id
     *
     * @return
     */
    public void setSpecialActiveId(String activeId) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        sp.edit().putString(FinalConstant.specialActiveId, activeId).apply();
    }

    /**
     * 是否第一次打开app
     *
     * @return
     */
    public void saveFristOpen(boolean isFirstOpen) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        sp.edit().putBoolean(FinalConstant.isFristOpen, isFirstOpen).apply();
    }

    /**
     * 是否登录过
     *
     * @return
     */
    public Boolean getIsSpokesMan() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getBoolean(Constant.isSpokesMan, false);
    }

    /**
     * 保存ticket
     *
     * @return
     */
    public void saveLoginTicket(String ticket) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        sp.edit().putString(FinalConstant.ticket, ticket).apply();
    }

    /**
     * 获取用户数据
     *
     * @return
     */
    public Map<String, Object> getuserInfo() {
        Map<String, Object> map = new HashMap<>();
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        try {
            map.put(FinalConstant.id, sp.getString(FinalConstant.id, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put(FinalConstant.userName, sp.getString(FinalConstant.userName, ""));
        map.put(FinalConstant.email, sp.getString(FinalConstant.email, ""));
        map.put(FinalConstant.is_login, sp.getBoolean(FinalConstant.is_login, false));
        map.put(FinalConstant.status, sp.getInt(FinalConstant.status, -1));
        map.put(FinalConstant.birthday, sp.getString(FinalConstant.birthday, ""));

        map.put(FinalConstant.phone, sp.getString(FinalConstant.phone, ""));
        map.put(FinalConstant.qq, sp.getString(FinalConstant.qq, ""));
        map.put(FinalConstant.nickName, sp.getString(FinalConstant.nickName, ""));
        map.put(FinalConstant.photo, sp.getString(FinalConstant.photo, ""));

        map.put(FinalConstant.phoneCertify, sp.getBoolean(FinalConstant.phoneCertify, false));
        if (sp.getInt(FinalConstant.gender, 0) == 1) {
            map.put(FinalConstant.gender, "男");
        } else if (sp.getInt(FinalConstant.gender, 0) == 2) {
            map.put(FinalConstant.gender, "女");
        } else {
            map.put(FinalConstant.gender, "");
        }
        map.put(FinalConstant.emailCertify, sp.getBoolean(FinalConstant.emailCertify, false));
        map.put(FinalConstant.idcardCertify, sp.getBoolean(FinalConstant.idcardCertify, false));
        map.put(FinalConstant.ticket, sp.getString(FinalConstant.ticket, ""));
        map.put(FinalConstant.lastLoginTime, sp.getString(FinalConstant.lastLoginTime, ""));
        map.put(FinalConstant.registerTime, sp.getString(FinalConstant.registerTime, ""));
        map.put(FinalConstant.waitPayCount, sp.getInt(FinalConstant.waitPayCount, 0));
        map.put(FinalConstant.waitDeliveryCount, sp.getInt(FinalConstant.waitDeliveryCount, 0));
        map.put(FinalConstant.waitReceiptCount, sp.getInt(FinalConstant.waitReceiptCount, 0));
        map.put(FinalConstant.waitEvaluationCount, sp.getInt(FinalConstant.waitEvaluationCount, 0));
        map.put(FinalConstant.afterSaleCount, sp.getInt(FinalConstant.afterSaleCount, 0));
        map.put(FinalConstant.myMessageCount, sp.getInt(FinalConstant.myMessageCount, 0));
        map.put(FinalConstant.skuFavoritesCount, sp.getInt(FinalConstant.skuFavoritesCount, 0));
        map.put(FinalConstant.shopFavoritesCount, sp.getInt(FinalConstant.shopFavoritesCount, 0));
        map.put(FinalConstant.myHistoryVisite, sp.getInt(FinalConstant.myHistoryVisite, 0));
        map.put(FinalConstant.venueFavoritesCount, sp.getInt(FinalConstant.venueFavoritesCount, 0));
        return map;
    }


    /**
     * 清楚用户数据，及登录状态
     *
     * @return
     */
    public void clearUserInfo() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(FinalConstant.id, null);
        editor.putString(FinalConstant.userName, null);
        editor.putBoolean(FinalConstant.is_login, false);
        editor.putString(FinalConstant.email, null);
        editor.putInt(FinalConstant.status, 0);
        editor.putString(FinalConstant.phone, null);
        editor.putString(FinalConstant.qq, null);
        editor.putString(FinalConstant.nickName, null);
        editor.putString(FinalConstant.photo, null);
        editor.putInt(FinalConstant.gender, 0);
        editor.putString(FinalConstant.ticket, null);
        editor.putInt(FinalConstant.waitPayCount, 0);
        editor.putInt(FinalConstant.waitDeliveryCount, 0);
        editor.putInt(FinalConstant.waitReceiptCount, 0);
        editor.putInt(FinalConstant.waitEvaluationCount, 0);
        editor.putInt(FinalConstant.afterSaleCount, 0);
        editor.putInt(FinalConstant.myMessageCount, 0);
        editor.putInt(FinalConstant.skuFavoritesCount, 0);
        editor.putInt(FinalConstant.shopFavoritesCount, 0);
        editor.putInt(FinalConstant.myHistoryVisite, 0);
        editor.putInt(FinalConstant.venueFavoritesCount, 0);
        editor.apply();
    }

    /**
     * 记录是否登录
     *
     * @param isLogin
     * @return
     */
    public Boolean saveLoginStatus(Boolean isLogin) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean(FinalConstant.is_login, isLogin);
        return et.commit();

    }

    public Boolean saveUserAccount(String account) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putString(FinalConstant.userName, account);
        return et.commit();
    }

    public String getUserAccount() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getString(FinalConstant.userName, "");
    }

    public Boolean clearUserAccount() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putString(FinalConstant.userName, "");
        return et.commit();
    }

    /**
     * 网络异常 不可点击界面取消
     *
     * @param click
     * @return
     */
    public Boolean errorOnClick(Boolean click) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean(Constant.IS_CLICK, click);
        return et.commit();
    }

    /**
     * -1表示原路返回
     *
     * @return
     */
    public Boolean getErrorOnClick() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getBoolean(Constant.IS_CLICK, false);
    }

    /**
     * 保存性别
     *
     * @param sex
     * @return
     */
    public void saveSex(String sex) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        if (sex.equals("男")) {
            et.putInt(FinalConstant.gender, 1);
        } else if (sex.equals("女")) {
            et.putInt(FinalConstant.gender, 2);
        } else {
            et.putInt(FinalConstant.gender, 0);
        }
        et.apply();
    }

    /**
     * 保存昵称
     *
     * @param userName
     * @return
     */
    public Boolean saveUserName(String userName) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putString(FinalConstant.nickName, userName);
        return et.commit();

    }

    /**
     * @param isBind
     * @return
     */
    public void saveBindData(boolean isBind) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean(FinalConstant.phoneCertify, isBind);
        et.apply();
    }

    /**
     * 保存手机
     *
     * @param cellPhone
     * @return
     */
    public void saveCellPhoneData(String cellPhone) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putString(FinalConstant.phone, cellPhone);
        et.apply();

    }

    /**
     * 保存当前请求版本更新的接口的时间，
     *
     * @param time
     * @return
     */
    public Boolean saveLastTime(long time) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putLong(Constant.lastTime, time);
        return et.commit();
    }

    /**
     * 保存进入登录界面  有的是需要直接返回  像购物车需要返回主界面
     *
     * @param time
     * @return
     */
    public Boolean saveLoginType(int time) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putInt(Constant.LOGIN_TYPE, time);
        return et.commit();
    }

    /**
     * -1表示原路返回
     *
     * @return
     */
    public int getLoginType() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getInt(Constant.LOGIN_TYPE, -1);
    }

    /**
     * 获取当前请求版本更新的接口的时间，
     *
     * @return
     */
    public long getLastgTime() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getLong(Constant.lastTime, 0L);
    }


    /**
     * 保存购物车本地商品数量
     *
     * @param carnum
     */
    public void putCarLocalNumber(int carnum) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        int num = carnum + getCarNumber();
        et.putInt(Constants.CAR_NUMBER, num);
        et.commit();
    }

    /**
     * 保存购物车网络商品数量
     *
     * @param carnum
     */
    public void putCarNetNumber(int carnum) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putInt(Constants.CAR_NUMBER, carnum);
        et.commit();
    }


    /**
     * 获取购物车 商品数量
     */
    public int getCarNumber() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getInt(Constants.CAR_NUMBER, 0);
    }


    public void putMessageNumber(int num) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putInt(Constants.MESSAGE_NUMBER, num);
        et.commit();
    }

    /**
     * 获取消息数量
     */
    public int getMessageNumber() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getInt(Constants.MESSAGE_NUMBER, 0);
    }

    /**
     * 保存别人的spokesmanCode
     *
     * @param spokesmanCode
     */
    public void putShareSpokesmanCode(String spokesmanCode) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putString(Constants.SHARE_SPOKESMAN_CODE, spokesmanCode);
        et.commit();
    }

    /**
     * 获取别人的spokesmanCode
     *
     * @return
     */
    public String getShareSpokesmanCode() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return sp.getString(Constants.SHARE_SPOKESMAN_CODE, "");
    }

    /**
     * 保存搜索历史关键词
     *
     * @param searchWord
     */
    public void putSearchGoodsName(String searchWord) {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        Gson gson = new Gson();
        List<String> keywordList = getSearchGoodsNameList();
        for (int i = 0; i < keywordList.size(); i++) {
            if (searchWord.equals(keywordList.get(i))) {
                return;
            }
        }
        keywordList.add(0, searchWord);
        if (keywordList.size() > 10) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < 10; i++)
                tempList.add(keywordList.get(i));
            et.putString(Constants.SEARCH_GOODS_NAME, gson.toJson(tempList));
        } else
            et.putString(Constants.SEARCH_GOODS_NAME, gson.toJson(keywordList));
        et.commit();
    }

    /**
     * 获取搜索历史关键词列表
     *
     * @return
     */
    public List<String> getSearchGoodsNameList() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String keywordListJson = sp.getString(Constants.SEARCH_GOODS_NAME, "");
        List<String> keywordList;
        if (!TextUtils.isEmpty(keywordListJson))
            keywordList = gson.fromJson(keywordListJson, new TypeToken<List<String>>() {
            }.getType());
        else
            keywordList = new ArrayList<>();
        return keywordList;
    }

    /**
     * 清空搜索历史关键词列表
     */
    public void clearSearchGoodsNameList() {
        SharedPreferences sp = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor et = sp.edit();
        et.putString(Constants.SEARCH_GOODS_NAME, "");
        et.commit();
    }
}
