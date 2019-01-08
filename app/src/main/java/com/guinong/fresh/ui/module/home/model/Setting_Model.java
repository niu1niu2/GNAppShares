package com.guinong.fresh.ui.module.home.model;


import com.guinong.lib_base.base.BaseModel;
import com.guinong.lib_commom.api.guinong.BaseApiClient;
import com.guinong.lib_commom.api.guinong.update.UpdateAppRequest;
import com.guinong.lib_commom.api.guinong.update.UpdateAppResponse;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author wangyu
 * @time 2017/8/8 0008 on 下午 15:33
 * @desc
 */
public class Setting_Model implements BaseModel {

    BaseApiClient mClient = new BaseApiClient();

    public IAsyncRequestState UpdateApp(UpdateAppRequest request, IAsyncResultCallback<UpdateAppResponse> callback, Object userState) {
        return mClient.getUpdateApp(request, callback, userState);
    }
}
