package com.guinong.lib_commom.api.guinong;

import com.guinong.lib_commom.api.guinong.update.UpdateAppRequest;
import com.guinong.lib_commom.api.guinong.update.UpdateAppResponse;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

public class BaseApiClient extends ApiClient {
    //版本更新
    public static final String GetUpdateApp = "/api/Public/GetUpdateApp";

    /**
     * 获取升级App
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getUpdateApp(UpdateAppRequest request, IAsyncResultCallback<UpdateAppResponse> callback, Object userState) {
        return apiGetRequest(UpdateAppResponse.class, NEW_HOST + GetUpdateApp, request, callback, userState);
    }
}
