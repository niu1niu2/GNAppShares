package com.guinong.lib_commom.api.guinong;

import android.content.Context;
import com.github.mzule.activityrouter.router.Routers;
import com.guinong.lib_commom.GNCommonApplication;
import com.guinong.lib_commom.constant.FinalConstant;
import com.guinong.net.RequestClient;
import com.guinong.net.interceptor.LoginInterceptor;
import com.guinong.net.interceptor.RetryIntercepter;
import com.guinong.net.listener.NetCallBackListener;
import com.qiyukf.unicorn.api.Unicorn;

import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author wangyu
 * @time 2017/7/31 0031 on 上午 10:05
 * @desc
 */
public class ApiClient extends RequestClient {
    protected static OkHttpClient mOkHttpClient = null;
    private static final int TIME_OUT = 60;
    //测试支付关闭 2018年1月8日16:19:12
    public static final String NH_HOST = "http://api.guinong.com/";
    public static String NEW_HOST = "http://dev.guinong.com:8762/";
    //public static String NEW_HOST = "http://192.168.1.248:8762/";
    public static String NEW_HOST1 = "http://192.168.1.248:8999/";
      //public static String NEW_HOST1 = "http://apiservice.guinong.com/";
       //public static String NEW_HOST = "http://apiservice.guinong.com/";
    public static final String IMAGE_HOST = "http://img.guinong.com";

    public static void contextInit(final Context context) {
        TICKET = FinalConstant.ticket;
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
      //  okHttpClientBuilder.dns(OkHttpDns.getInstance(GNCommonApplication.getApplicaContext()));
        if (context != null) {
            //okHttpClientBuilder.cookieJar(new CookierManager(context));
            baseContext = context;
        }
        okHttpClientBuilder.followRedirects(true); //设置重定向 其实默认也是true
        LoginInterceptor interceptor = new LoginInterceptor(GNCommonApplication.context);
        interceptor.setNetCallBackListener(new NetCallBackListener() {
            @Override
            public void onNotLogon(Request request) {
                if (request.url().url().toString().contains("GetUserDefaultShippingAddress") || request.url().url().toString().contains("CalculateFreight")
                        || request.url().url().toString().contains("CartItemCount")
                        || request.url().url().toString().contains("GetMemberInfomation")
                        || request.url().url().toString().contains("GetMemberCenterCounts")
                        || request.url().url().toString().contains("GetMemberOrderCount")
                        || request.url().url().toString().contains("api/user/integral/info")
                        || request.url().url().toString().contains("integral/product/productList")) {
                    return;
                }
                if (Unicorn.isServiceAvailable()) {
                    Unicorn.logout();
                }
                Routers.open(context, "modularization://guinong.login");
            }
        });
        okHttpClientBuilder.networkInterceptors().add(interceptor);
        okHttpClientBuilder.addInterceptor(new RetryIntercepter(3));
        okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        mOkHttpClient = okHttpClientBuilder.build();
    }

    static {
        if (mOkHttpClient == null) {
            contextInit(null);
        }
    }

    public ApiClient() {
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return mOkHttpClient;
    }
}
