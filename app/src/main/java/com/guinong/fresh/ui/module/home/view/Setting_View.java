package com.guinong.fresh.ui.module.home.view;


import com.guinong.lib_base.base.BaseView;
import com.guinong.lib_commom.api.guinong.update.UpdateAppResponse;

/**
 * @author wangyu
 * @time 2017/8/8 0008 on 下午 15:33
 * @desc
 */
public interface Setting_View extends BaseView {

    void showAppProgress(float progress);
    void showAppSize(float progress);
    void showUpdateApp(UpdateAppResponse response);

}
