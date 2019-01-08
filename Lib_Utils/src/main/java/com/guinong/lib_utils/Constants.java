package com.guinong.lib_utils;

/**
 * Created by wangyu on 2017/4/12.
 */
public class Constants {

    /**
     * 是否是调试版本
     */
    public static boolean IS_DEBUG = true;

    public static final String TAG = "com.cd.coolbuy";

    /**
     * 渠道号
     */
    public static final String CHANNEL_ID = "CHANNEL_ID";


    /**
     * token值
     */
    public static final String TOKEN = "token";

    public static final String VERSION = "version";

    public static final String SALT ="f337c7eae1a7497892e90a17d52e4f6b";//接口访问服务端定义的加盐参数

    /**
     * 登录账户
     */
    public static final String LOGIN_ACCOUNT = "LOGIN_ACCOUNT";


    /**
     * //购物车商品数量    记录小红点
     */
    public static final String CAR_NUMBER = "CAR_NUMBER";


    /**
     * //消息数量    记录小红点
     */
    public static final String MESSAGE_NUMBER = "MESSAGE_NUMBER";

    /**
     * 别人分享给自己商品等，这个人的spokesmanCode
     */
    public static final String SHARE_SPOKESMAN_CODE = "share_spokesman_code";


    public static final String SEARCH_GOODS_NAME = "search_goods_name";


    /**
     * 进入我的订单某一项
     */
    public static final int ORDER_TYPE_ALL = 0;
    public static final int ORDER_TYPE_WAITPAY = 1;
    public static final int ORDER_TYPE_WAITSEND = 2;
    public static final int ORDER_TYPE_WAITCHARGE = 3;
    public static final int ORDER_TYPE_EVALUATION = 4;
    public static final int ORDER_TYPE_AFTERSALES = 5;

    /**
     * 订单状态
     */
    public static final int ORDER_STATE_ALL = 0; // 全部订单
    public static final int ORDER_STATE_WAIT_PAY = 1; // 待付款
    public static final int ORDER_STATE_WAIT_SEND = 2; // 待发货
    public static final int ORDER_STATE_WAIT_CHARGE = 3; // 待收货
    public static final int ORDER_STATE_CLOSED = 4; // 已关闭
    public static final int ORDER_STATE_DONE = 5; // 已完成
    public static final int ORDER_STATE_EVALUATION = 7; // 未评价


    /**
     * 送年货订单状态
     */
    public static final int SPRING_ORDER_STATE_ALL = 0;//全部送年货订单
    public static final int SPRING_ORDER_STATE_WAIT_PAY = 1; // 待付款
    public static final int SPRING_ORDER_STATE_PAY = 2; // 已付款
    public static final int SPRING_ORDER_STATE_CANCER = 3; // 已取消



    public static final String ORDER_STATE_WAIT_PAY_STR = "待付款";
    public static final String ORDER_STATE_WAIT_SEND_STR = "待发货";
    public static final String ORDER_STATE_WAIT_CHARGE_STR = "待收货";
    public static final String ORDER_STATE_CLOSED_STR = "已关闭";
    public static final String ORDER_STATE_DONE_STR = "已完成";
    public static final String ORDER_STATE_EVALUATION_STR = "未评价";

    /**
     * 在订单详情页取消订单等操作，返回前一个页面，并刷新列表
     */
    public static final int REQUEST_CODE_FOR_OPERATE_ORDER = 0;
    public static final String RESULT_CLICK_POS = "click_pos";
    public static final String OPERATE_TYPE = "operate_type";
    public static final int OPERATE_TYPE_CANCEL = 0;
    public static final int OPERATE_TYPE_CONFIRM = 1;


    /**
     * 退款相关状态
     */
    public static final int REFUND_STATE_1 = 1; // 1 待商家审核
    public static final int REFUND_STATE_2 = 2; // 2 待买家寄货
    public static final int REFUND_STATE_3 = 3; // 3 待商家收货
    public static final int REFUND_STATE_4 = 4; // 4 商家拒绝
    public static final int REFUND_STATE_5 = 5; // 5 商家通过审核
    public static final int REFUND_STATE_6 = 6; // 6 待平台确认
    public static final int REFUND_STATE_7 = 7; // 7 退款成功

    public static final String REFUND_STATE_STR_1 = "待商家审核"; // 1 待商家审核
    public static final String REFUND_STATE_STR_2 = "待买家寄货"; // 2 待买家寄货
    public static final String REFUND_STATE_STR_3 = "待商家收货"; // 3 待商家收货
    public static final String REFUND_STATE_STR_4 = "商家拒绝"; // 4 商家拒绝
    public static final String REFUND_STATE_STR_5 = "商家通过审核"; // 5 商家通过审核
    public static final String REFUND_STATE_STR_6 = "待平台确认"; // 6 待平台确认
    public static final String REFUND_STATE_STR_7 = "退款成功"; // 7 退款成功


    /**
     * 通知类型
     */
    public static final int OPEN_ORDER = 1; // 1 订单

    public static String[] images = new String[]{
            "http://himg2.huanqiu.com/attachment2010/2017/1102/20171102070437102.jpg"
            , "https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=f4eda2c00a3b5bb5aada28ac57babe5c/a2cc7cd98d1001e9e5d8b764b10e7bec55e797f1.jpg"
            , "https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=c6b4fc9adeca7bcb6976cf7ddf600006/6d81800a19d8bc3e058fc3938b8ba61ea9d345e0.jpg",
            "http://imgmini.eastday.com/pushimg/20171117/1510874297604232.jpg",
            "https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=99fd5adf6e061d95694b3f6a1a9d61b4/0b46f21fbe096b63c6d87db70c338744eaf8ac17.jpg",
            "http://images.china.cn/attachement/jpg/site1000/20161208/d02788e9b28a19b2e80924.jpg",
            "http://upload.cankaoxiaoxi.com/2017/0601/1496319083789.jpg"
            , "http://upload.cankaoxiaoxi.com/2017/0712/1499848728394.jpg", "http://imgmini.eastday.com/pushimg/20171117/1510874299537788.jpg"
            , "http://img5.pcpop.com/ArticleImages/730x547/3/3651/003651969.jpg"
            , "http://a.hiphotos.baidu.com/image/pic/item/e850352ac65c10384bfac6d1be119313b07e8918.jpg",
            "https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=f0334a2c43540923be646b2cf331ba6c/f703738da9773912ce99316ef2198618367ae206.jpg",
            "https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=4c5ed0afe7dde711f3df4ba4c686a57e/d01373f082025aaf3d331e61f9edab64034f1a12.jpg"
            , "http://himg2.huanqiu.com/attachment2010/2017/1102/20171102070437820.jpg"
            , "http://imgmini.eastday.com/pushimg/20171117/1510874297650928.jpg"
            , "http://img.mp.itc.cn/upload/20170523/4ea90c1526ca44b0a6ad54dc838aef02_th.jpg"
            , "http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd09ccfb7903b30f2442a70fa9.jpg"
    };
}
