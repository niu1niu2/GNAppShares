package com.guinong.fresh.ui.module.home.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import com.guinong.lib_base.base.BasePresenter;
import com.guinong.lib_commom.api.guinong.update.UpdateAppRequest;
import com.guinong.lib_commom.api.guinong.update.UpdateAppResponse;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.BaseActivityLifecycleCallbacks;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.fresh.ui.module.home.model.Setting_Model;
import com.guinong.fresh.ui.module.home.view.Setting_View;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;


/**
 * @author wangyu
 * @time 2017/8/8 0008 on 下午 15:32
 * @desc
 */
public class Setting_Presenter extends BasePresenter<Setting_View, Setting_Model> {

    public Setting_Presenter(String mTag, Context mContext, Setting_Model mModel, Setting_View mView) {
        super(mTag,mContext, mModel, mView);
    }

    public void UpdateApp(UpdateAppRequest request) {
        BaseActivityLifecycleCallbacks.putCall(mTag,mModel.UpdateApp(request, new IAsyncResultCallback<UpdateAppResponse>() {
            @Override
            public void onComplete(UpdateAppResponse response, Object userState) {
                mView.showUpdateApp(response);
            }

            @Override
            public void onError(NetworkException error, Object userState) {

            }
        }, 0));
    }



    public void downLoad(String url) {
//        dialog = new DownLoadDialog(mContext);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//        dialog.setProgressText(0f);
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "guinong.apk")//
                {
                    @Override
                    public void inProgress(float v, long l) {
//                        BigDecimal b = new BigDecimal(v * 100);
//                        float f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
//                        dialog.setProgressText(v * 100);
//                        String aa = "asda";
                        mView.showAppSize(l/1024.0f/10244.0f);
                        mView.showAppProgress((int)(v * 100));
                    }

                    @Override
                    public void inProgress(float progress) {
//                        dialog.setProgressText(progress);
                        mView.showAppProgress((int)progress);
                        //mProgressBar.setProgress((int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e) {
                        mView.stopAll();
                    }


                    @Override
                    public void onResponse(File file) {
                        //dialog.dismiss();
                        installAPK(file);
                    }
                });
    }

    private void installAPK(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(mContext, "com.guiong.up.fileprovider", file);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        if (mContext.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            mContext.startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

}
