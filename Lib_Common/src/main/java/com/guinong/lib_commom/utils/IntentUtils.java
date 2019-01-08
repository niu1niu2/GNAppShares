package com.guinong.lib_commom.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.guinong.lib_base.event.AddressEvent;
import com.guinong.lib_utils.Constants;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangyu
 * @time 2017/4/12 14:15
 * @desc activity跳转
 */
public class IntentUtils {

    //启动模式
    //Intent.FLAG_ACTIVITY_NEW_TASK;  是为Activity指定 “SingleTask”启动模式
    //Intent.FLAG_ACTIVITY_SINGLE_TOP  Activity指定 “SingleTop”启动模式
    //Intent.FLAG_ACTIVITY_CLEAR_TOP  启动时会将与该Activity在同一任务栈的其它Activity出栈，一般与SingleTask启动模式一起出现
    public static String TAB_INDEX = "index";
    public static String DATA = "data";
    public static String DATA1 = "data1";
    public static String ORDER_TYPE = "order_type";
    public static String EVENT = "event";
    public static String INFO = "info";
    public static String BOO = "boo";
    public static String BOO1 = "boo1";
    public static String CATEGORYTYPE = "TYPE";
    public static final int REQUEST_SEARCH = 1;
    public static String TYPE = "type";//区别进入某个界面的类型

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)));
    }


    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, List<?> data) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DATA, (Serializable) data);
        Intent intent = new Intent(context, activity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void gotoActivity(Context context, Class<?> activity, long data, String info) {
        Bundle bundle = new Bundle();
        bundle.putLong(DATA, data);
        bundle.putString(INFO, info);
        Intent intent = new Intent(context, activity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data, String data1) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(INFO, data1)));
    }


    public static void gotoActivity(Context context, Class<?> activity, String data, String data1, boolean boo) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(INFO, data1).putExtra(BOO, boo)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, int data, List<String> data1) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(INFO, (Serializable) data1)));
    }


    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data, boolean boo) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(BOO, boo)));
    }

    public static void gotoActivity(Context context, Class<?> activity, String data,String infoName, boolean boo,boolean isHome,int type) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(IntentUtils.INFO,infoName).putExtra(BOO, boo).putExtra(BOO1,isHome).putExtra(IntentUtils.CATEGORYTYPE,type)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data, String data1, String data2) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(INFO, data1).putExtra(TAB_INDEX, data2)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data, String data1, String data2, AddressEvent event) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(INFO, data1).putExtra(TAB_INDEX, data2).putExtra(EVENT, event)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, Serializable data, int flag) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).setFlags(flag)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, long data, int flag) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).setFlags(flag)));
    }


    public static void gotoActivity(Context context, Class<?> activity, int data, int flag) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(DATA1,flag)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, String data, int flag) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).setFlags(flag)));
    }

    /**
     * 带参需返回结果
     *
     * @param context
     * @param activity
     * @param data
     * @param request
     */
    public static void gotoStartActivity(Activity context, Class<?> activity, String data, int request) {
        context.startActivityForResult((new Intent(context, activity).putExtra(DATA, data)), request);
    }


    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivityFlags(Context context, Class<?> activity, String data, int flag) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).setFlags(flag)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, Serializable data) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, long data) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)));
    }

    public static void gotoActivity(Context context, Class<?> activity, int data) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)));
    }

    public static void gotoActivity(Context context, Class<?> activity, Serializable data, Serializable data1) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(DATA1, data1)));
    }

    /**
     * 带参无需返回结果
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivity(Context context, Class<?> activity, Serializable data, String type, String parms, String paytype) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(TYPE, type).putExtra(INFO, parms).putExtra(TAB_INDEX, paytype)));
    }

    public static void gotoActivity(Context context, Class<?> activity, String data, String type, String parms, String paytype) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data).putExtra(TYPE, type).putExtra(INFO, parms).putExtra(TAB_INDEX, paytype)));
    }


    /**
     * 带2参数，需返回结果，从Fragment跳转
     *
     * @param fragment
     * @param activity
     * @param data
     * @param data1
     * @param request
     */
    public static void gotoActivity(Fragment fragment, Class<?> activity, String data, String data1, int request) {
        fragment.startActivityForResult((new Intent(fragment.getActivity(), activity).putExtra(DATA, data)).putExtra(INFO, data1), request);
    }

    /**
     * 无参无需返回结果
     *
     * @param context
     * @param activity
     */
    public static void gotoActivity(Context context, Class<?> activity) {
        context.startActivity((new Intent(context, activity)));
    }


    public static void gotoActivity(Context context, Class<?> activity, String data, String data1, Serializable data2) {
        context.startActivity((new Intent(context, activity).putExtra(DATA, data)).putExtra(INFO, data1).putExtra(DATA1, data2));
    }

    /*   *//**
     * 分类商品列表
     *
     * @param context
     *//*
    public static void gotoClassTwoActivity(Context context, CategoryResponse.SubCategoriesBeanX infoBean, int position) {

    }*/

    /**
     * 无参需返回结果
     *
     * @param context
     * @param activity
     * @param request
     */
    public static void gotoActivity(Activity context, Class<?> activity, int request) {
        context.startActivityForResult((new Intent(context, activity)), request);
    }

    /**
     * 清理顶部栈跳转
     *
     * @param context
     * @param activity
     */
    public static void gotoActivityWithClearTop(Context context, Class<?> activity, String data, String data1) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(DATA, data).putExtra(INFO, data1);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * 清理顶部栈跳转
     *
     * @param context
     * @param activity
     * @param data
     */
    public static void gotoActivityWithClearTop(Context context, Class<?> activity, int data) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(DATA, data);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * 返回该Activity 指定Fragment视图
     * 该Activity一般为SingleTask  模式 MainActivity
     *
     * @param context
     * @param index
     */
    public static void gotoMainActivity(Context context, Class<?> activity, int index) {
        context.startActivity((new Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(TAB_INDEX, index)));
    }

    public static void gotoMainActivityPay(Context context, Class<?> activity, int index) {
        context.startActivity((new Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(TAB_INDEX, index)));
    }

    /**
     * GoodsDetealActivity
     *
     * @param context
     * @param info
     */
    public static void gotoShopDetealActivity(Context context, Class<?> activity, String info) {
        context.startActivity(new Intent(context, activity).putExtra(DATA, info));
    }

    /* */

    /**
     * 我的订单
     *
     * @param context
     * @param type    ApplyForCustomerServiceListActivity  MeOrderActivity
     */
    public static void gotoMeOrderActivity(Context context, Class<?> activity1, Class<?> activity2, int type) {
        if (type == Constants.ORDER_TYPE_AFTERSALES)
            context.startActivity((new Intent(context, activity1)));
        else
            context.startActivity((new Intent(context, activity2).putExtra(ORDER_TYPE, type)));
    }

    /**
     * 跳转到我的订单，带启动模式 MeOrderActivity
     *
     * @param context
     * @param type
     */
    public static void gotoMeOrderActivityWithClearTop(Context context, Class<?> activity, int type) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void gotoMeOrderActivityWithClearTopPay(Context context, Class<?> activity, int type) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 跳转到我的订单，带启动模式 PublicWelfareActivity
     *
     * @param context
     * @param type
     */
    public static void gotoSpringOrderActivityWithClearTop(Context context, Class<?> activity, int type) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /**
     * 跳转至我的订单，清理栈，回调onNewIntent刷新页面 MeOrderActivity
     *
     * @param context
     * @param type
     */
    public static void gotoMeOrderActivityWithNewIntent(Context context, Class<?> activity, int type) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    /**
     * 从外部购买后跳转到订单页，清理栈 MeOrderActivity
     *
     * @param context
     * @param type
     * @param isOutPay
     */
    public static void gotoMeOrderActivityWithClearTop(Context context, Class<?> activity, int type, boolean isOutPay) {
        Intent intent = new Intent(context, activity).putExtra(ORDER_TYPE, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("isOutPay", isOutPay);
        context.startActivity(intent);
    }

    /**
     * 设置
     *
     * @param context
     *//*
    public static void gotoSettingActivity(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }


    *//**
     * 我的足迹
     *
     * @param context
     *//*
    public static void gotoMeFootprintActivity(Context context) {
        context.startActivity(new Intent(context, MeFootprintActivity.class));
    }

    */

    /**
     * 分类商品列表
     *
     * @param context
     *//*
    public static void gotoClassTwoActivity(Context context, CategoriesBean.ResultBean.SubCategoriesBeanX infoBean, int position) {
        context.startActivity(new Intent(context, ClassTwoActivity.class).putExtra(INFO, infoBean).putExtra(DATA, position));
    }

    public static void gotoShopDetealActivity(Context context, String info) {
        context.startActivity(new Intent(context, ShopDetealActivity.class).putExtra(DATA, info));
    }


    /**
     * 带启动模式启动Activity
     *
     * @param context
     * @param activity
     * @param launchMode
     */
    public static void gotoActivityWithLaunchMode(Context context, Class<?> activity, int launchMode) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(launchMode);
        context.startActivity(intent);
    }

    /**
     * 带启动模式启动Activity
     *
     * @param context
     * @param activity
     * @param launchMode1
     * @param launchMode2
     */
    public static void gotoActivityWithLaunchMode(Context context, Class<?> activity, int launchMode1, int launchMode2) {
        Intent intent = new Intent(context, activity);
        intent.addFlags(launchMode1);
        intent.addFlags(launchMode2);
        context.startActivity(intent);
    }

    /**
     * 带启动模式、参数启动Activity
     *
     * @param context
     * @param activity
     * @param launchMode
     */
    public static void gotoActivityWithLaunchMode(Context context, Class<?> activity, String data1, String data2, int launchMode) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(DATA, data1);
        intent.putExtra(INFO, data2);
        intent.setFlags(launchMode);
        context.startActivity(intent);
    }

    /**
     * 带启动模式、参数启动Activity
     *
     * @param context
     * @param activity
     * @param launchMode
     */
    public static void gotoActivityWithLaunchMode(Context context, Class<?> activity, String data1, int launchMode) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(DATA, data1);
        intent.setFlags(launchMode);
        context.startActivity(intent);
    }

    /* *//**
     * 二维码扫描进入商品详情（目前用于代言人分享商品）
     * http://dev.guinong.com:8810/m-wap/product/detail/744?spokesManCode=86360c02-54ff-43c8-81b3-061417c17405
     *
     * @param context
     * @param url
     *//*
    public static void gotoWebPageOrShopDetailFromScanCode(Context context, String url) {
        if (url.startsWith(api.HOST + "m-wap/product/detail/")) {
            int index = url.lastIndexOf("/");
            String paramsStr = url.substring(index + 1);
            LogUtil.error("yangmbin:", paramsStr);
            String[] params = paramsStr.split("\\?");
            String goodsId, spokesManCode;
            if (params.length == 2) {
                goodsId = params[0];
                spokesManCode = params[1];
                Uri uri = Uri.parse("gnup://spokesman_share_goods?spokesManCode=" + spokesManCode + "&goodsId=" + goodsId);
                Intent intent = new Intent();
                intent.setData(uri);
                context.startActivity(intent);
            }
        } else {
            IntentUtils.gotoActivity(context, QrqWbActivity.class, url);
        }
    }*/

    /**
     * 扫描二维码
     *
     * @param context
     */
    /*public static void gotoScanCodeActivity(Fragment context) {
        IntentIntegrator.forSupportFragment(context).setOrientationLocked(true).setCaptureActivity(ScanCodeActivity.class).initiateScan();
    }*/

}
