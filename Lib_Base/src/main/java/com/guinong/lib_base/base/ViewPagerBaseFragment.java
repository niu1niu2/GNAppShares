package com.guinong.lib_base.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guinong.lib_base.R;
import com.guinong.lib_base.views.LoadingBox;
import com.guinong.net.callback.BaseActivityLifecycleCallbacks;
import com.guinong.net.request.IAsyncRequestState;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment抽象类，配合ViewPager使用，实现懒加载
 *
 * @author ymb
 *         Create at 2017/7/13 14:00
 */
public abstract class ViewPagerBaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {
    public P mPresenter;
    public M mModel;
    public Context mContext;
    private View rootView;
    private LoadingBox box;

    // 是否创建了视图
    private boolean hasCreateView;
    // Fragment是否可见
    private boolean isFragmentVisible;
    // Fragment第一次可见
    private boolean isFragmentFirstVisible = true;


    private View.OnClickListener mReloadListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            networkRetry();
        }
    };

    private View.OnClickListener mCustomListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            customClick();
        }
    };

    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hasCreateView = false;
        isFragmentVisible = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        mContext = this.getActivity();
        if (rootView.findViewById(R.id.box) != null) {
            box = new LoadingBox(mContext, rootView.findViewById(R.id.box));
            box.setClickListener(mReloadListener);
            box.setCustomClickListener(mCustomListener);
        }
        mUnbinder = ButterKnife.bind(this, rootView);
        initModel();
        initPresenter();
        initView();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!hasCreateView && getUserVisibleHint()) {
            judgeIsFirst();
            onFragmentVisible(true);
            isFragmentVisible = true;
        }
    }

    /**
     * 获取布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 初始化Model
     */
    public abstract void initModel();

    /**
     * 初始化Presenter
     */
    public abstract void initPresenter();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 添加网络请求到请求列表
     * @param state
     */
    public void appendNetCall(IAsyncRequestState state) {
        BaseActivityLifecycleCallbacks.putCall(getActivity().getClass().getName(),state);
    }

    /**
     * 全覆盖加载框
     */
    public void showFillLoading() {
        box.showLoadingLayout();
    }

    /**
     * 显示透明加载框
     */
    public void showTransLoading() {
        box.showTransLoadingLayout();
    }

    /**
     * 显示无数据页面
     */
    public void showNoDataLayout() {
        box.showNoDataLayout();
    }

    /**
     * 显示无网络页面
     */
    public void showNetOffLayout() {
        box.showInternetOffLayout();
    }

    /**
     * 显示网络错误页面
     */
    public void showNetErrorLayout() {
        box.showExceptionLayout();
    }

    /**
     * 停止加载框
     */
    public void stopAll() {
        box.hideAll();
    }


    /**
     * 显示自定义页面
     */
    public void showCustomLayout(int layoutId) {
        View customView = getActivity().getLayoutInflater().inflate(layoutId, null, false);
        box.addCustomView(customView, layoutId + "");
        box.showCustomView(layoutId + "");
    }

    /**
     * 网络重载按钮
     */
    protected void networkRetry() {}

    /**
     * 自定义页面按钮
     */
    protected void customClick() {}

    /**
     * 设置无数据信息
     * @param message
     */
    public void setNoDataMessage(String message) {
        box.setNoDataMessage(message);
    }

    /**
     * 设置无网络信息
     * @param message
     */
    public void setNetOffMessage(String message) {
        box.setInternetOffMessage(message);
    }

    /**
     * 设置网络错误信息
     * @param message
     */
    public void setNetErrorMessage(String message) {
        box.setExceptionMessage(message);
    }

    /**
     * 判断Fragment是否可见，先于onCreateView执行
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null)
            return;
        hasCreateView = true;
        if (isVisibleToUser) {
            judgeIsFirst();
            onFragmentVisible(true);
            isFragmentVisible = true;
            return;
        }
        if (isFragmentVisible) {
            onFragmentVisible(false);
            isFragmentVisible = false;
        }
    }

    /**
     * 子类重写，监控可见状态
     *
     * @param isVisible true  不可见——可见
     *                  false 可见——不可见
     */
    protected void onFragmentVisible(boolean isVisible) {

    }

    /**
     * 子类重写，第一次可见时调用
     */
    protected void onFragmentFirstVisible() {

    }

    /**
     * 判断是否第一次可见
     */
    private void judgeIsFirst() {
        if (isFragmentFirstVisible) {
            isFragmentFirstVisible = false;
            onFragmentFirstVisible();
        }
    }

    /**
     * 判断view不为空并显示
     * @param view
     */
    public void emptyVisibity(View view){
        if(view != null){
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 判断view不为空并隐藏
     * @param view
     */
    public void emptyGone(View view){
        if(view != null){
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 判断view不为空且是否获取控件
     * @param view
     * @param isEnabled
     */
    public void emptyEnabled(View view,boolean isEnabled){
        if(null != view){
            view.setEnabled(isEnabled);
        }
    }

    /**
     * 设置TextView值
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv, String str){
        if(null != tv && null != str){
            tv.setText(str);
        }
    }

    /**
     * 设置TextView值
     * @param tv
     * @param str
     */
    public void emptyTvTitle(TextView tv,int str){
        if(null != tv){
            tv.setText(str);
        }
    }

    /**
     * 设置View背景颜色
     * @param view
     * @param color
     */
    public void emptyViewBackColor(View view ,int color){
        if(null != view){
            view.setBackgroundColor(color);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        if (mPresenter != null)
            mPresenter.onDestroy();
        // 帧动画结束
        if (box != null) {
            box.stopFrameAnim();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public void stopRefresh() {}

}
