package com.guinong.lib_base.weight.refresh.header;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import com.guinong.lib_base.views.loading.DiamondLoadingView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class GNRefreshHeader extends LinearLayout implements RefreshHeader {

    private DiamondLoadingView mLoadingView;

    public GNRefreshHeader(Context context) {
        super(context);
        initView(context);
    }
    public GNRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context);
    }
    public GNRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context);
    }
    private void initView(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        mLoadingView = new DiamondLoadingView(context, null);
        addView(new View(context), DensityUtil.dp2px(20), DensityUtil.dp2px(20));
        addView(mLoadingView, DensityUtil.dp2px(30), DensityUtil.dp2px(30));
        addView(new View(context), DensityUtil.dp2px(20), DensityUtil.dp2px(20));
    }

    @NonNull
    public View getView() {
        return this;//真实的视图就是自己，不能返回null
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;//指定为平移，不能null
    }
    @Override
    public void onStartAnimator(RefreshLayout layout, int headHeight, int extendHeight) {
        //开始动画
    }
    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        mLoadingView.stop();

        return 500;//延迟500毫秒之后再弹回
    }
    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }
    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownCanceled:
                Log.e("yangmbin", "PullDownCanceled");
                mLoadingView.stop();
                break;
        }
    }
    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {
    }
    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }
    @Override
    public void onPullingDown(float percent, int offset, int headHeight, int extendHeight) {
        mLoadingView.start();
    }
    @Override
    public void onReleasing(float percent, int offset, int headHeight, int extendHeight) {

    }
    @Override
    public void setPrimaryColors(@ColorInt int ... colors){
    }
}