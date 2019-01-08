package com.guinong.lib_utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

/**
 * 图片验证码的工具类
 * Created by Administrator on 2017/5/4.
 */
public class PicCodeUtil {

    /**
     * string转成bitmap
     *
     */
    public static Drawable byteToDrawable(String icon) {

        byte[] img=Base64.decode(icon.getBytes(), Base64.DEFAULT);
        Bitmap bitmap;
        if (img != null) {


            bitmap = BitmapFactory.decodeByteArray(img,0, img.length);
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bitmap);

            return drawable;
        }
        return null;

    }
}
