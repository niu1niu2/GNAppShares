package com.guinong.lib_utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.concurrent.ExecutionException;

/**
 * Created by wangyu on 2015/12/28.
 */
public class FileDownLoadUtils {

    private Context context;
    private String mImageUrl;
    private OnAttachmentDownListener listener;
    private static FileDownLoadUtils fileDownLoadUtils;

    private FileDownLoadUtils() {
    }

    public static FileDownLoadUtils getInstance() {
        if (fileDownLoadUtils == null) {
            fileDownLoadUtils = new FileDownLoadUtils();
        }
        return fileDownLoadUtils;
    }

    public void addDown(String url, Context context) {
        this.context = context;
        this.mImageUrl = url;
        new FileDownTask(mImageUrl).execute();
    }

    public class FileDownTask extends AsyncTask<String, Void, Bitmap> {
        private String urls;
        public FileDownTask(String urls) {
            this.urls = urls;
        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;

            try {
                bitmap = Glide.with(context)
                        .load(urls)
                        .asBitmap()
                        .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null){
                listener.onCompleted(bitmap);
            }
        }
    }

    public void setOnImageDownListener(OnAttachmentDownListener listener) {
        this.listener = listener;
    }

    public static interface OnAttachmentDownListener {
        void onCompleted(Bitmap bitmap);
    }
}
