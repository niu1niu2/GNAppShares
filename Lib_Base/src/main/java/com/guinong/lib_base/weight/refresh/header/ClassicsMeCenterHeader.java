package com.guinong.lib_base.weight.refresh.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.guinong.lib_base.R;
import com.guinong.lib_base.views.loading.MumLoadingView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wangyu
 * @time 2017/8/22 0022 on 上午 9:34
 * @desc
 */
@SuppressWarnings("unused")
public class ClassicsMeCenterHeader extends RelativeLayout implements RefreshHeader {

//    public static String REFRESH_HEADER_PULLDOWN = "下拉可以刷新";
//    public static String REFRESH_HEADER_REFRESHING = "正在刷新...";
//    public static String REFRESH_HEADER_LOADING = "正在加载...";
//    public static String REFRESH_HEADER_RELEASE = "释放立即刷新";
//    public static String REFRESH_HEADER_FINISH = "刷新完成";
//    public static String REFRESH_HEADER_FAILED = "刷新失败";
//    public static String REFRESH_HEADER_LASTTIME = "上次更新 M-d HH:mm";
//
//    protected String KEY_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";

//    protected Date mLastTime;
//    protected TextView mTitleText;
//    protected TextView mLastUpdateText;
    protected ImageView mArrowView;
    protected MumLoadingView mProgressView;
    protected SharedPreferences mShared;
    protected RefreshKernel mRefreshKernel;
    protected SpinnerStyle mSpinnerStyle = SpinnerStyle.Translate;
   // protected DateFormat mFormat = new SimpleDateFormat(REFRESH_HEADER_LASTTIME, Locale.CHINA);
    protected int mFinishDuration = 500;
    protected int mBackgroundColor;
    protected int mPaddingTop = 20;
    protected int mPaddingBottom = 20;
    protected boolean mEnableLastTime = true;

    //<editor-fold desc="RelativeLayout">
    public ClassicsMeCenterHeader(Context context) {
        super(context);
        this.initView(context, null);
    }

    public ClassicsMeCenterHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context, attrs);
    }

    public ClassicsMeCenterHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs);
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public ClassicsMeCenterHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        DensityUtil density = new DensityUtil();

//        LinearLayout layout = new LinearLayout(context);
//        layout.setId(android.R.id.widget_frame);
//        layout.setGravity(Gravity.CENTER_HORIZONTAL);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        mTitleText = new TextView(context);
//        mTitleText.setText(REFRESH_HEADER_PULLDOWN);
//        mTitleText.setTextColor(0xff666666);
//
//        mLastUpdateText = new TextView(context);
//        mLastUpdateText.setTextColor(0xff7c7c7c);
//        LinearLayout.LayoutParams lpHeaderText = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
//        layout.addView(mTitleText, lpHeaderText);
//        LinearLayout.LayoutParams lpUpdateText = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
//        layout.addView(mLastUpdateText, lpUpdateText);

//        LayoutParams lpHeaderLayout = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
//        lpHeaderLayout.addRule(CENTER_IN_PARENT);
//        addView(layout,lpHeaderLayout);

        LayoutParams lpArrow = new LayoutParams(density.dip2px(20), density.dip2px(20));
        lpArrow.addRule(CENTER_HORIZONTAL);
        lpArrow.addRule(LEFT_OF, android.R.id.widget_frame);
        mArrowView = new ImageView(context);
        addView(mArrowView, lpArrow);

        LayoutParams lpProgress = new LayoutParams((ViewGroup.LayoutParams)lpArrow);
        lpProgress.addRule(CENTER_HORIZONTAL);
        lpProgress.addRule(LEFT_OF, android.R.id.widget_frame);
        mProgressView = new MumLoadingView(context,null);
        mProgressView.animate().setInterpolator(new LinearInterpolator());
        addView(mProgressView, lpProgress);

        if (isInEditMode()) {
            mArrowView.setVisibility(GONE);
            //mTitleText.setText(REFRESH_HEADER_REFRESHING);
        } else {
            mProgressView.setVisibility(GONE);
        }

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ClassicsHeader);

        //lpUpdateText.topMargin = ta.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, density.dip2px(0));
        lpProgress.rightMargin = ta.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, density.dip2px(20));
        lpArrow.rightMargin = lpProgress.rightMargin;

        lpArrow.width = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, lpArrow.width);
        lpArrow.height = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, lpArrow.height);
        lpProgress.width = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, lpProgress.width);
        lpProgress.height = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, lpProgress.height);

        lpArrow.width = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, lpArrow.width);
        lpArrow.height = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, lpArrow.height);
        lpProgress.width = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, lpProgress.width);
        lpProgress.height = ta.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, lpProgress.height);

        mFinishDuration = ta.getInt(R.styleable.ClassicsHeader_srlFinishDuration, mFinishDuration);
        mEnableLastTime = ta.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, mEnableLastTime);
        mSpinnerStyle = SpinnerStyle.values()[ta.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle,mSpinnerStyle.ordinal())];

       // mLastUpdateText.setVisibility(mEnableLastTime ? VISIBLE : GONE);

        if (ta.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
            mArrowView.setImageDrawable(ta.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
        } else {
            mArrowView.setImageResource(R.mipmap.xlistview_arrow);
        }

        if (ta.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
            mProgressView.setImageDrawable(ta.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
        } else {
            //
        }

//        if (ta.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
//            mTitleText.setTextSize(ta.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, 16));
//        } else {
//            mTitleText.setTextSize(16);
//        }

//        if (ta.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
//            mLastUpdateText.setTextSize(ta.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, 12));
//        } else {
//            mLastUpdateText.setTextSize(12);
//        }

        int primaryColor = ta.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0);
        int accentColor = ta.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0);
        if (primaryColor != 0) {
            if (accentColor != 0) {
                setPrimaryColors(primaryColor, accentColor);
            } else {
                setPrimaryColors(primaryColor);
            }
        } else if (accentColor != 0) {
            setPrimaryColors(0, accentColor);
        }

        ta.recycle();

        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                setPadding(getPaddingLeft(), mPaddingTop = density.dip2px(20), getPaddingRight(), mPaddingBottom = density.dip2px(20));
            } else {
                setPadding(getPaddingLeft(), mPaddingTop = density.dip2px(20), getPaddingRight(), mPaddingBottom = getPaddingBottom());
            }
        } else {
            if (getPaddingBottom() == 0) {
                setPadding(getPaddingLeft(), mPaddingTop = getPaddingTop(), getPaddingRight(), mPaddingBottom = density.dip2px(20));
            } else {
                mPaddingTop = getPaddingTop();
                mPaddingBottom = getPaddingBottom();
            }
        }

        try {//try 不能删除-否则会出现兼容性问题
            if (context instanceof FragmentActivity) {
                FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
                if (manager != null) {
                    List<Fragment> fragments = manager.getFragments();
                    if (fragments != null && fragments.size() > 0) {
                        setLastUpdateTime(new Date());
                        return;
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

       // KEY_LAST_UPDATE_TIME += context.getClass().getName();
        mShared = context.getSharedPreferences("ClassicsHeader", Context.MODE_PRIVATE);
       // setLastUpdateTime(new Date(mShared.getLong(KEY_LAST_UPDATE_TIME, System.currentTimeMillis())));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), mPaddingTop, getPaddingRight(), mPaddingBottom);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //</editor-fold>

    //<editor-fold desc="RefreshHeader">
    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {
        mRefreshKernel = kernel;
        mRefreshKernel.requestDrawBackgoundForHeader(mBackgroundColor);
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void onPullingDown(float percent, int offset, int headHeight, int extendHeight) {
    }

    @Override
    public void onReleasing(float percent, int offset, int headHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int headHeight, int extendHeight) {

    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        mProgressView.setVisibility(GONE);
//        if (success) {
//            mTitleText.setText(REFRESH_HEADER_FINISH);
//            setLastUpdateTime(new Date());
//        } else {
//            mTitleText.setText(REFRESH_HEADER_FAILED);
//        }
        return mFinishDuration;//延迟500毫秒之后再弹回
    }

    @Override@Deprecated
    public void setPrimaryColors(int... colors) {
        if (colors.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable)) {
                setPrimaryColor(colors[0]);
            }
            if (colors.length > 1) {
                setAccentColor(colors[1]);
            } else {
                setAccentColor(colors[0] == 0xffffffff ? 0xff666666 : 0xffffffff);
            }
        }
    }

    @NonNull
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return mSpinnerStyle;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
//                restoreRefreshLayoutBackground();
               // mLastUpdateText.setVisibility(mEnableLastTime ? VISIBLE : GONE);
            case PullDownToRefresh:
//                mTitleText.setText(REFRESH_HEADER_PULLDOWN);
                mArrowView.setVisibility(VISIBLE);
                mProgressView.setVisibility(GONE);
                mArrowView.animate().rotation(0);
                break;
            case Refreshing:
               // mTitleText.setText(REFRESH_HEADER_REFRESHING);
                mProgressView.setVisibility(VISIBLE);
                mArrowView.setVisibility(GONE);
                break;
            case ReleaseToRefresh:
               // mTitleText.setText(REFRESH_HEADER_RELEASE);
                mArrowView.animate().rotation(180);
//                replaceRefreshLayoutBackground(refreshLayout);
                break;
            case Loading:
                mArrowView.setVisibility(GONE);
                mProgressView.setVisibility(GONE);
//                mLastUpdateText.setVisibility(GONE);
//                mTitleText.setText(REFRESH_HEADER_LOADING);
                break;
        }
    }
    //</editor-fold>

    //<editor-fold desc="API">
    public ClassicsMeCenterHeader setProgressBitmap(Bitmap bitmap) {
        mProgressView.setImageBitmap(bitmap);
        return this;
    }
    public ClassicsMeCenterHeader setProgressDrawable(Drawable drawable) {
        mProgressView.setImageDrawable(drawable);
        return this;
    }
    public ClassicsMeCenterHeader setProgressResource(@DrawableRes int resId) {
        mProgressView.setImageResource(resId);
        return this;
    }
    public ClassicsMeCenterHeader setArrowBitmap(Bitmap bitmap) {
        mArrowView.setImageBitmap(bitmap);
        return this;
    }
    public ClassicsMeCenterHeader setArrowDrawable(Drawable drawable) {
        mArrowView.setImageDrawable(drawable);
        return this;
    }
    public ClassicsMeCenterHeader setArrowResource(@DrawableRes int resId) {
        mArrowView.setImageResource(resId);
        return this;
    }

    public ClassicsMeCenterHeader setLastUpdateTime(Date time) {
//        mLastTime = time;
//        mLastUpdateText.setText(mFormat.format(time));
//        if (mShared != null && !isInEditMode()) {
//            mShared.edit().putLong(KEY_LAST_UPDATE_TIME, time.getTime()).apply();
//        }
        return this;
    }

    public ClassicsMeCenterHeader setTimeFormat(DateFormat format) {
//        mFormat = format;
//        mLastUpdateText.setText(mFormat.format(mLastTime));
        return this;
    }

    public ClassicsMeCenterHeader setSpinnerStyle(SpinnerStyle style) {
        this.mSpinnerStyle = style;
        return this;
    }

    public ClassicsMeCenterHeader setPrimaryColor(int primaryColor) {
        setBackgroundColor(mBackgroundColor = primaryColor);
        if (mRefreshKernel != null) {
            mRefreshKernel.requestDrawBackgoundForHeader(mBackgroundColor);
        }
        return this;
    }

    public ClassicsMeCenterHeader setAccentColor(int accentColor) {
//        mTitleText.setTextColor(accentColor);
//        mLastUpdateText.setTextColor(accentColor&0x00ffffff|0xcc000000);
        return this;
    }

    public ClassicsMeCenterHeader setFinishDuration(int delay) {
        mFinishDuration = delay;
        return this;
    }

    public ClassicsMeCenterHeader setEnableLastTime(boolean enable) {
//        mEnableLastTime = enable;
//        mLastUpdateText.setVisibility(enable ? VISIBLE : GONE);
        if (mRefreshKernel != null) {
            mRefreshKernel.requestRemeasureHeightForHeader();
        }
        return this;
    }

    public ClassicsMeCenterHeader setTextSizeTitle(float size) {
       // mTitleText.setTextSize(size);
        if (mRefreshKernel != null) {
            mRefreshKernel.requestRemeasureHeightForHeader();
        }
        return this;
    }

    public ClassicsMeCenterHeader setTextSizeTitle(int unit, float size) {
       // mTitleText.setTextSize(unit, size);
        if (mRefreshKernel != null) {
            mRefreshKernel.requestRemeasureHeightForHeader();
        }
        return this;
    }

    public ClassicsMeCenterHeader setTextSizeTime(float size) {
      //  mLastUpdateText.setTextSize(size);
        if (mRefreshKernel != null) {
            mRefreshKernel.requestRemeasureHeightForHeader();
        }
        return this;
    }

    public ClassicsMeCenterHeader setTextSizeTime(int unit, float size) {
       // mLastUpdateText.setTextSize(unit, size);
        if (mRefreshKernel != null) {
            mRefreshKernel.requestRemeasureHeightForHeader();
        }
        return this;
    }

    public ClassicsMeCenterHeader setTextTimeMarginTop(float dp) {
        return setTextTimeMarginTopPx(DensityUtil.dp2px(dp));
    }

    public ClassicsMeCenterHeader setTextTimeMarginTopPx(int px) {
//        MarginLayoutParams lp = (MarginLayoutParams)mLastUpdateText.getLayoutParams();
//        lp.topMargin = px;
       // mLastUpdateText.setLayoutParams(lp);
        return this;
    }

    public ClassicsMeCenterHeader setDrawableMarginRight(float dp) {
        return setDrawableMarginRightPx(DensityUtil.dp2px(dp));
    }

    public ClassicsMeCenterHeader setDrawableMarginRightPx(int px) {
        MarginLayoutParams lpArrow = (MarginLayoutParams)mArrowView.getLayoutParams();
        MarginLayoutParams lpProgress = (MarginLayoutParams)mProgressView.getLayoutParams();
        lpArrow.rightMargin = lpProgress.rightMargin = px;
        mArrowView.setLayoutParams(lpArrow);
        mProgressView.setLayoutParams(lpProgress);
        return this;
    }

    public ClassicsMeCenterHeader setDrawableSize(float dp) {
        return setDrawableSizePx(DensityUtil.dp2px(dp));
    }

    public ClassicsMeCenterHeader setDrawableSizePx(int px) {
        ViewGroup.LayoutParams lpArrow = mArrowView.getLayoutParams();
        ViewGroup.LayoutParams lpProgress = mProgressView.getLayoutParams();
       lpArrow.width = lpProgress.width = px;
        lpArrow.height = lpProgress.height = px;
        mArrowView.setLayoutParams(lpArrow);
        mProgressView.setLayoutParams(lpProgress);
        return this;
    }

    public ClassicsMeCenterHeader setDrawableArrowSize(float dp) {
        return setDrawableArrowSizePx(DensityUtil.dp2px(dp));
    }

    public ClassicsMeCenterHeader setDrawableArrowSizePx(int px) {
        ViewGroup.LayoutParams lpArrow = mArrowView.getLayoutParams();
        lpArrow.width = px;
        lpArrow.height = px;
        mArrowView.setLayoutParams(lpArrow);
        return this;
    }

    public ClassicsMeCenterHeader setDrawableProgressSize(float dp) {
        return setDrawableProgressSizePx(DensityUtil.dp2px(dp));
    }

    public ClassicsMeCenterHeader setDrawableProgressSizePx(int px) {
        ViewGroup.LayoutParams lpProgress = mProgressView.getLayoutParams();
        lpProgress.width = px;
        lpProgress.height = px;
        mProgressView.setLayoutParams(lpProgress);
        return this;
    }

    public ImageView getArrowView() {
        return mArrowView;
    }

    public ImageView getProgressView() {
        return mProgressView;
    }

//    public TextView getTitleText() {
//        return mTitleText;
//    }
//
//    public TextView getLastUpdateText() {
//        return mLastUpdateText;
//    }
}
