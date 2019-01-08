package com.guinong.lib_commom.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.guinong.lib_commom.R;
import com.guinong.lib_commom.api.guinong.ApiClient;
import com.guinong.lib_utils.CommonUtils;


/**
 * @author wangyu
 * @time 2017/4/12 14:11
 * @desc 图片处理工具类
 */
public class GlideUtil {
    /**
     * 设置用户头像
     *
     * @param context
     * @param subUrl
     * @param imageView
     */
    public static void setUserIcon(Context context, String subUrl, ImageView imageView) {
        if (TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.head_man);
        }  else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl).placeholder(R.mipmap.head_man).into(imageView);
        }else {
            Glide.with(context).load(ApiClient.IMAGE_HOST+subUrl).placeholder(R.mipmap.head_man).into(imageView);
        }
    }



    public static void setUserIcon(int recose, ImageView imageView) {
        imageView.setImageResource(recose);
    }


    public static void setPicNoHost(final Context context, final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.icon_default);
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl).asBitmap().placeholder(R.mipmap.icon_default).into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl).asBitmap().placeholder(R.mipmap.icon_default).into(imageView);
        }
    }

    //圆形
    public static void setPicNoHostCir(Context context,final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.icon_default_cir);
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl + CommonUtils.getImageNetSize(100)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default_cir).into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl + CommonUtils.getImageNetSize(100)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default_cir).into(imageView);
        }
    }

    public static void setPicNoHost6(Context context,final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.icon_default6);
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl + CommonUtils.getImageNetSize(400)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default6).into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl +
                    CommonUtils.getImageNetSize(400)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default6).into(imageView);
        }
    }

    //320 X 320
    public static void setPicNoHost3(Context context,final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.icon_default3);
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl + CommonUtils.getImageNetSize(220)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default3).into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl + CommonUtils.getImageNetSize(220)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default3).into(imageView);
        }
    }

    //135 X 135
    public static void setPicNoHost1(Context context,final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.icon_default1);
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl + CommonUtils.getImageNetSize(50)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default1).into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl + CommonUtils.getImageNetSize(50)).asBitmap().centerCrop().placeholder(R.mipmap.icon_default1).into(imageView);
        }
    }

    //150 X 150
    public static void setPicNoHost2(Context context,final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.icon_default2);
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl + CommonUtils.getImageNetSize(150)).asBitmap().placeholder(R.mipmap.icon_default2).into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl + CommonUtils.getImageNetSize(150)).asBitmap().placeholder(R.mipmap.icon_default2).into(imageView);
        }
    }

    public static void setPicNoHostCategory(Context context,final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            return;
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl + CommonUtils.getImageNetSize(150)).asBitmap().into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl + CommonUtils.getImageNetSize(150)).asBitmap().into(imageView);
        }
    }

    public static void setRectangleImage(Context context,final String subUrl, final ImageView imageView) {
        if (subUrl==null||TextUtils.isEmpty(subUrl)) {
            imageView.setImageResource(R.mipmap.icon_default7);
        } else if (subUrl.contains("http")) {
            Glide.with(context).load(subUrl).asBitmap().centerCrop().placeholder(R.mipmap.icon_default7).into(imageView);
        } else {
            Glide.with(context).load(ApiClient.IMAGE_HOST + subUrl).asBitmap().centerCrop().placeholder(R.mipmap.icon_default7).into(imageView);
        }
    }
}
