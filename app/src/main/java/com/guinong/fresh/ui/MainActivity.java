package com.guinong.fresh.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.guinong.lib_base.base.BaseActivity;
import com.guinong.lib_base.event.EventBusInstance;
import com.guinong.lib_base.weight.FragmentStatusSaveTabHost;
import com.guinong.lib_commom.api.guinong.update.UpdateAppRequest;
import com.guinong.lib_commom.api.guinong.update.UpdateAppResponse;
import com.guinong.lib_commom.utils.IntentUtils;
import com.guinong.lib_commom.widget.dialog.ShowNewVersionDialog;
import com.guinong.lib_utils.AppVersionUtil;
import com.guinong.lib_utils.PermissionUtil;
import com.guinong.lib_utils.TableConfig;
import com.guinong.fresh.R;
import com.guinong.fresh.ui.module.center.fragment.CenterFragment;
import com.guinong.fresh.ui.module.home.fragment.HomeFragment;
import com.guinong.fresh.ui.module.home.model.Setting_Model;
import com.guinong.fresh.ui.module.home.presenter.Setting_Presenter;
import com.guinong.fresh.ui.module.home.view.Setting_View;
import com.guinong.fresh.ui.module.other.fragment.OtherFragment;

import java.util.ArrayList;
public class MainActivity extends BaseActivity<Setting_Presenter, Setting_Model> implements Setting_View {
    public static final int MSG_INDEX = 0;
    FragmentStatusSaveTabHost mTabHost;
    private long exitTime;      //是否退出应用时间
    private int mCurrentTab = 0;
    private int lastCurrentTab = 0;
    private ArrayList<View> tabViews = new ArrayList<>();
    public static Context mContext;
    private static final TableConfig[] tableConfig = new TableConfig[]{
            new TableConfig(R.string.tab_home,
                    HomeFragment.class,
                    R.drawable.tab_five_selecter),
            new TableConfig(R.string.tab_other,
                    OtherFragment.class,
                    R.drawable.tab_welfare_selector),
            new TableConfig(R.string.tab_center,
                    CenterFragment.class,
                    R.drawable.tab_star_selector),
    };
    private long time;
    private ShowNewVersionDialog showNewVersionDialog;
    private UpdateAppResponse mVersionUpdateResponse;
    private boolean isMustUpdate;
    private boolean isBack;

    @Override
    public void addActivity() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        int index = intent.getIntExtra(IntentUtils.TAB_INDEX, MainActivity.MSG_INDEX);
        if (mTabHost != null) {
            mTabHost.setCurrentTab(index);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   EventBusInstance.getInstance().registerEvent(this);
        initFragmentTabHost();
        mContext = this;
    }


    @Override
    public void initModel() {
        mModel = new Setting_Model();
    }

    @Override
    public void initPresenter() {
        mPresenter = new Setting_Presenter(this.getClass().getName(), this, mModel, this);
        UpdateAppRequest request = new UpdateAppRequest();
        request.setAppVersion(AppVersionUtil.getVersionName(this));
        request.setType("2");
        // mPresenter.UpdateApp(request);
    }

    @Override
    protected void setThisActivityName() {
        thisActivityName = "MainActivity";
    }

    @Override
    public void initView() {

    }

    @Override
    public void showAppProgress(float progress) {
        showNewVersionDialog.setProgressText(progress);
    }

    @Override
    public void showAppSize(float progress) {

    }

    @Override
    public void showUpdateApp(UpdateAppResponse response) {
        if (response.getDownLoadUrl() != null && !TextUtils.isEmpty(response.getDownLoadUrl()) && !response.getDownLoadUrl().equals("null")) {
            if (response.getDescription() == null && TextUtils.isEmpty(response.getDescription())) {
                response.setDescription("检查到新版本，确认更新吗");
            }
            mVersionUpdateResponse = response;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (PermissionUtil.verifyStoragePermissions(this) && PermissionUtil.verifyStoragePermissions(this)) {
                    showDialog(response);
                }
            } else {
                showDialog(response);
            }
//            DialogUtils.showCustomServiceDialog(SettingActivity.this, new CommonDialog.ClickCallBack() {
//                @Override
//                public void onConfirm() {
//                    IntentUtils.gotoActivity(mContext,DownLoadActivity.class,response.getDownLoadUrl());
//                }
//            }, response.getDescription(), "取消", "更新");
        }
    }

    private void showDialog(final UpdateAppResponse response) {
        //response.setDescription("上的苦还是读后大数据时代立即晒福利还赛复活甲ad死了沙发好看的\n的数据法律手段积分的GV离得在甲方的还款客服比较好瓦房表达式阿尔法好客山东。\nvkjfdlbj行政村在你的在你撒地方困了就睡登录手动的数据苏菲娜说服力离开市场法");
        isMustUpdate = response.isIsMustUpdate();
        showNewVersionDialog = new ShowNewVersionDialog(this, new ShowNewVersionDialog.ClickCallBack() {
            @Override
            public void onConfirm(String content) {
                mPresenter.downLoad(response.getDownLoadUrl());
            }
        }, response);
        if (response.isIsMustUpdate()) {
            showNewVersionDialog.setCanceledOnTouchOutside(false);
            showNewVersionDialog.setVisibleDeleteImageView(false);
            showNewVersionDialog.setCancelable(false);
            showNewVersionDialog.show();
        } else if (response.isIsAdviseUpdate()) {
            showNewVersionDialog.setCanceledOnTouchOutside(false);
            showNewVersionDialog.setVisibleDeleteImageView(true);
            showNewVersionDialog.show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == 0 && grantResults[1] == 0) {
            showDialog(mVersionUpdateResponse);
        } else {
            // ToastUtil.TextToast(mContext,"没有下载安装apk的权限");
        }
    }

    //初始化FragmentTabHost
    public void initFragmentTabHost() {
        mTabHost = (FragmentStatusSaveTabHost) findViewById(R.id.mtabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (int i = 0; i < tableConfig.length; i++) {
            mTabHost.addTab(mTabHost.newTabSpec(getString(tableConfig[i].titleId)).setIndicator(getIndicator(i)),
                    tableConfig[i].targetClass, null);
        }

        if (Build.VERSION.SDK_INT >= 11) {
            mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);// 设置不显示分割线
        }
        initCurrentTab();
        /**
         * 注意，mTabHost先执行点击事件，在执行setOnTabChangedListener事件
         * 所以mCurrentTab表示当前所在页面
         */
        mTabHost.getTabWidget().getChildTabViewAt(tableConfig.length - 2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTabHost.setCurrentTab(tableConfig.length - 2);
            }
        });

        mTabHost.getTabWidget().getChildTabViewAt(tableConfig.length - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTabHost.setCurrentTab(tableConfig.length - 1);
            }
        });

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                hideSoftKeyboard();
                lastCurrentTab = mCurrentTab;
                for (int i = 0; i < tableConfig.length; i++) {
                    if (tabId.equals(getString(tableConfig[i].titleId))) {
                        mCurrentTab = i;
                        break;
                    }
                }
            }
        });
    }

    //根据index返回一个填充了TabConfig的view
    private View getIndicator(final int index) {
        RelativeLayout view = (RelativeLayout) View.inflate(this, R.layout.tab_indicator_view, null);
        TextView tv = (TextView) view.findViewById(R.id.tab_item);
        ImageView tab_icon = (ImageView) view.findViewById(R.id.tab_icon);
        tab_icon.setImageResource(tableConfig[index].tabImage);
        tv.setText(tableConfig[index].titleId);
        tabViews.add(view);
        return view;
    }

    private void initCurrentTab() {
        mTabHost.setCurrentTab(mCurrentTab);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
        Process.killProcess(Process.myPid());
    }


    @Override
    public void onBackPressed() {
        int index;
        if ((isMustUpdate && showNewVersionDialog != null && showNewVersionDialog.isShowing()) || isBack) {
            return;
        }

        if (mTabHost != null) {
            index = mTabHost.getCurrentTab();
            if (index == 0) {
                super.onBackPressed();
            } else {
                mTabHost.setCurrentTab(0);
            }
        }
    }

}
