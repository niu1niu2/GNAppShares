package com.guinong.lib_utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

import cn.finalteam.toolsfinal.StorageUtils;

/**
 * @author wangyu
 * @time 2017/5/2 12:50
 * @desc 媒体帮助类
 */
public class AppMediaManager {

    public static final int REQUEST_CODE_PICK_IMAGE = 1001;
    public static final int REQUEST_CODE_CAPTURE_CAMEIA = 1002;
    public static final int REQUEST_CODE_PHOTO_CORP = 1003;

    private static AppMediaManager instance;

    private AppMediaManager() {
    }

    public static AppMediaManager getInstance() {
        if (instance == null) {
            instance = new AppMediaManager();
        }
        return instance;
    }

    /**
     * 从相册获取图片
     * @param activity
     * @param requestCode
     */
    public void getImageFromAlbum(Activity activity, int requestCode) {
        File mSdcardTempFile=new File(StorageUtils.getCacheDirectory(activity), "/temp/"+System.currentTimeMillis() + ".jpg");
        Uri mImageUri = Uri.fromFile(mSdcardTempFile);
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
        activity.startActivityForResult(intent, requestCode);
    }
}
