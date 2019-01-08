package com.guinong.lib_base.views.loading;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.guinong.lib_base.R;
import com.guinong.lib_base.views.loading.FrameAnim.FrameAnimView;

/**
 * 菱形加载图
 * @author ymb
 * Create at 2017/5/26 19:02
 */
/*
 public class DiamondLoadingView extends FrameAnimView {

   @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public DiamondLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
*/

public class DiamondLoadingView extends ImageView {
    private AnimationDrawable mAnimationDrawable;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public DiamondLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mAnimationDrawable = new AnimationDrawable();
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00000), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00001), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00002), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00003), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00004), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00005), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00006), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00007), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00008), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00009), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00010), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00011), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00012), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00013), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00014), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00015), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00016), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00017), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00018), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00019), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00020), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00021), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00022), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00023), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00024), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00025), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00026), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00027), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00028), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00029), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00030), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00031), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00032), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00033), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00034), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00035), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00036), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00037), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00038), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00039), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00040), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00041), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00042), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00043), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00044), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00045), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00046), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00047), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00048), 40);
        mAnimationDrawable.addFrame(ContextCompat.getDrawable(context, R.mipmap.loading_5_00050), 40);
        mAnimationDrawable.setOneShot(false);
        this.setBackground(mAnimationDrawable);
    }

    public void start() {
        if (mAnimationDrawable != null && !mAnimationDrawable.isRunning())
            mAnimationDrawable.start();
    }

    public void stop() {
        if (mAnimationDrawable != null && mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
    }

}
