package com.guinong.lib_utils;

/**
 * @author chenshuangniu
 * @time 2016/11/3 15:42
 * @content
 * @amend
 * @viersion 1.0
 */

public class Constant {
    public static final String Custom_Phone = "400-115-6060";//400客服电话
    public static final int UPDATE_TIME = 1000 * 60 * 60 * 24;//24小时
    //qq的app_id
    public static final String QQ_APP_ID = "1106158340";
    public static final String WX_APP_ID = "wx5e3f5b903e71e540";
    public static final String WX_AppSecret = "1c21ec2a43c3dc811397017b89a24e6a";

    public static final String TYPE_NOTICE = "notice";
    public static final String TYPE_SCHOOL = "school";
    public static final String TYPE = "type";
    public static final String TYPE_HOME_WORK = "homework";
    public static final String TYPE_ATTENDANCE_ALL = "0";
    public static final String TYPE_ATTENDANCE_LATE = "1";
    public static final String TYPE_ATTENDANCE_LEAVE = "2";
    public static final String TYPE_ATTENDANCE_NO = "3";
    public static final String TYPE_ATTENDANCE_EARLY = "4";
    public static final int REQUEST_CODE_CAMERA = 1000;//打开相机
    public static final int REQUEST_CODE_GALLERY = 1001;//打开相册
    //登录parm
    public static final String LOGIN_UERNAME_KEY = "username";
    public static final String LOGIN_PWD_KEY = "pwd";
    public static final String REQUEST_STATUS_SUCCESSS = "1";//请求成功标志
    public static final String REQUEST_STATUS_FAIR = "400";//请求失败标志

    /**
     * shared没有登录过  没有记住都是no
     */
    public static final String NO = "no";
    /**
     * 是否登录过
     */
    public static final String IS_FREIST = "isfrist";
    public static final String IS_CLICK = "click";

    /**
     * 是否第一次打开app
     */
    public static final String isfristopen = "isfristopen";
    /**
     * 中途登录  区别于  也就是用么没有登录  但是打开有关用户的接口  就需要调取登录接口  购物车进入类型
     */
    public static final String ENTER_TYPE_FROM_SHOP_CART = "halfway";
    /**
     * 默认进入activity类型
     */
    public static final String ENTER_TYPE_FROM_DEFAULT = "default";
    /**
     * 商品订单进入activity类型
     */
    public static final String ENTER_TYPE_FROM_SHOP_ORDER = "shop_order";
    /**
     * 购物车进入订单提交
     */
    public static final String ENTER_TYPE_FROM_SHOP_CART_SUBMIT = "shop_cart_submit";
    /**
     * 商品详情进入订单提交
     */
    public static final String ENTER_TYPE_FROM_SHOP_DETAIL_SUBMIT = "detail_submit";
    /**
     * 公益行进入订单提交
     */
    public static final String ENTER_TYPE_FROM_VOLUNTEER_SUBMIT = "volunteer_submit";
    /**
     * shared登录过  记住都是yes
     */
    public static final String YES = "yes";
    /**
     * shared的用户名key
     */
    public static final String USER_NAME = "Username";
    /**
     * id记录绑定
     */
    public static final String USER_Id = "Id";
    /**
     * 版本号
     */
    public static final String VERSION = "version";
    /**
     * shared的密码key
     */
    public static final String USER_PWD = "Password";
    /**
     * shared的记住密码key
     */
    public static final String REMEMBER = "rember";
    /**
     * shared的是否是第一次登录key
     */
    public static final String IS_FRIST_LOGIN = "is_frist_login";
    /**
     * 刷新
     */
    public static final String TYPE_FRESH = "fresh";

    public static final String TYPE_INIT = "INIT";
    /**
     * 加载更多
     */
    public static final String TYPE_MORE = "more";


    /**
     * 筛选商品条件
     */
    public static final int SECTYPE_DEFAULT = 1;    //默认
    public static final int SECTYPE_SALES = 2;      //销量
    public static final int SECTYPE_SRCPRICE = 3;      //价格
    public static final int SECTYPE_EVALUTION = 4;  //评价数

    public static final int TYPE_DEFAULT = 0;  //默认综合
    public static final int TYPE_SEC_SALES = 1; //销量升序
    public static final int TYPE_DES_SALES = 2;     //销量降序
    public static final int TYPE_SEC_PRICE = 3; //价格升序
    public static final int TYPE_DES_PRICE = 4;     //价格降序

    /**
     * 升降序
     */
    public static final int SRCPRICE = 1;   //  升序
    public static final int DESPRICE = 2;   //降序


    /**
     * 用户信息
     */
    public static final String userId = "userId";    //
    public static final String userKey = "userKey";      //
    public static final String isSpokesMan = "isSpokesMan";      //
    public static final String isEnterLogin = "isEnterLogin";
    public static final String isEnableSpokerSettings = "isEnableSpokerSettings";      //
    public static final String userName = "userName";      //
    public static final String nickName = "nickName";      //
    public static final String photo = "photo";      //
    public static final String allOrders = "allOrders";      //
    public static final String waitingForPay = "waitingForPay";      //
    public static final String waitingForRecieve = "waitingForRecieve";      //
    public static final String waitingForDelivery = "waitingForDelivery";      //
    public static final String waitingForComments = "waitingForComments";      //
    public static final String refundOrders = "refundOrders";      //
    public static final String cellPhone = "cellPhone";      //
    public static final String favoriteShop = "favoriteShop";      //
    public static final String favoriteProduct = "favoriteProduct";      //
    public static final String counpon = "counpon";      //
    public static final String integral = "integral";      //
    public static final String myGroup = "myGroup";      //
    public static final String validateDate = "integral";      //
    public static final String sex = "sex";      //
    /**
     * 第二次  加载
     */
    public static final String SECOND_LOAD = "second";
    /**
     * 第一次 加载
     */
    public static final String FRIST_LOAD = "frist";

    /**
     *
     */
    public static final String lastTime = "lastTime";      //
    public static final String LOGIN_TYPE = "logintype";      //

    /**
     * 首页数据模型
     */

    public static final String BANNER_IARGER = "1";
    public static final String BANNER_SMALL = "2";
    public static final String GOODS_LISTONE = "101";
    public static final String GOODS_LISTTWO = "102";
    public static final String GOODS_ITEM = "103";
    public static final String GOODS_BLEND = "104";  //废弃
    public static final String GOODS_LIST_IMAGE = "105";
    public static final String ITEM_LIST = "201";
    public static final String GRID_ITEM = "106";

    /**
     * 首页商品打开类型
     */
    public static final int TYPE_DETEAL = 1;   //打开商品详情页面
    public static final int TYPE_SHOP = 2;    //打开店铺
    public static final int TYPE_ACTIVITY = 3;  //打开营销活动页
    public static final int TYPE_SEARCH = 4;    //搜索页
    public static final int TYPE_URL = 99;     //打开URL

    /**
     * 评论类型
     */
    public static final int COMMENT_ALL = 0;  //所有评论
    public static final int COMMENT_GOOD = 1;   //好评
    public static final int COMMENT_BAD = 3;    //差评

    /**
     * 友盟统计埋点
     */
    public static final String CLICKSCAN = "mScan";   //扫一扫
    public static final String CLICKSEARCH = "mSearch";   //搜索

    public static final String CLICKBanner = "mBanner";   //打Banner被点击
    public static final String CLICKENTER_DETEAL = "deteal";   //进入商品详情
    public static final String CLICKENTER_DETEAL_CAR = "deteal_car";   //商品详情进入购物车
    public static final String CLICKENTER_DETEAL_CUSTOMER = "mCustomer";   //商品详情进入客服
    public static final String CLICKENTER_DETEAL_ADDCAR = "addCar";   //商品详情添加购物车
    public static final String CLICKENTER_DETEAL_BUYNOW = "mBuynow";   //商品详情立即购买
    public static final String CLICKENTER_DETEAL_SPECIFICATIONS = "specifications";   //商品详情规格选择
    public static final String CLICKENTER_DETEAL_ADDRESS = "clickShopDetealAddress";   //商品详情选择地址
    public static final String CLICKENTER_DETEAL_SHARE = "ShopDetealShare";   //商品详情分享
    public static final String CLICKENTER_DETEAL_SHOP = "DetealShop";   //商品详情进入店铺
    public static final String CLICKENTER_CLASS_HOTGOODS = "hotGoods";   //分类热门商品点击
    public static final String CLICKENTER_CLASS_HOTSHOP = "hotShop";   //分类热门店铺点击
    public static final String CLICKENTER_TOPSELECT = "topSelect";   //首页顶部栏


    /*niu start*/
    public static final String BECOME_SPOKERMAN = "become_spokesman";   //成为代言人
    public static final String BECOME_SPOKERMAN_DETAIL = "become_spokesman_detail";   //点击立即成为代言人
    public static final String ADDRESS_SPOKERMAN = "spokesman_address";   //代言人界面-点击【地址更改】
    public static final String DETAIL_SPOKERMAN = "detail_spokerman";   //礼包详情界面-点击【立即成为代言人】
    public static final String ORDER_AFFRIM_BACK = "order_affrim_back";   //确认订单-返回
    public static final String ORDER_AFFRIM_SUBMIT = "order_affrim_submit";   //确认订单-提交订单
    public static final String PAY_CLOSE = "pay_close";   //支付界面-关闭
    public static final String PAY_GO = "pay_go";   //支付界面-去支付
    public static final String ALIPAY_CANCLE = "alipay_cancle";   //支付方式-支付宝-取消/打开/未付款返回
    public static final String WECHAT_CANCLE = "wechat_cancle";   //支付方式-微信-取消/打开/未付款
    public static final String PAY_QUICK_BANK = "pay_quick_bank";   //支付方式-快捷支付
    public static final String PAY_QUICK_BANK_BACK = "pay_quick_bank_back";   //快捷支付-返回
    public static final String PAY_QUICK_BANK_LIMIT = "pay_quick_bank_limit";   //快捷支付-交易限额
    public static final String PAY_QUICK_BANK_NEW = "pay_quick_bank_new";   //快捷支付-使用新银行卡支付
    public static final String PAY_QUICK_BANK_NEW_INTO_NUMBER = "pay_quick_bank_new_into_number";   //快捷支付-输入银行卡号
    public static final String PAY_QUICK_BANK_NEW_BIND_NEXT = "pay_quick_bank_new_bind_next";   //绑定银行卡-下一步
    public static final String PAY_QUICK_BANK_NEW_BIND_BACK = "pay_quick_bank_new_bind_back";   //绑定银行卡-返回
    public static final String PAY_QUICK_BANK_NEW_BIND_OPEN_QUICK = "pay_quick_bank_new_bind_open_quick";   //绑定银行卡-开通快捷支付
    public static final String PAY_QUICK_OPEN_ORDER = " OpenOrderSubmit";   //绑定银行卡-开通快捷支付
    public static final String QUICK_OK = "quick_ok";   //快捷支 付成功
    public static final String ALIPAY_OK = "alipay_ok";   //快捷支付 成功
    public static final String WECHAT_OK = "wechat_ok";   //快捷支付 成功
    /*niu end*/
    public static final String ISSPOKERMAN_SUCCESS = "spokerman_Success";   //成功成为代言人

    /**
     * 友盟统计 个人中心 By yangmbin
     */


    /**
     * 友盟统计埋点--luowei--
     */
    public static final String CLICKMESSAGE = "mMessage";   //消息1
    public static final String CLICK_WX_LOGIN = "click_wx_login";  //点击微信登录1
    public static final String CLICK_UNION_ACCOUNT = "click_union_account";  //点击关联账号
    public static final String CLICK_ENTER_UNION_ACCOUNT = "click_enter_union_account";  //点击关联进入关联账号
    public static final String CLICK_LOGIN = "click_login";  //点击登录1
    public static final String CLICK_LOGIN_ONBACKPRESSED = "click_login_onbackpressed";  //点击登录-返回
    public static final String CLICK_REGISTER = "click_register";  //点击注册1
    public static final String CLICK_REGISTER_ONBACKPRESSED = "click_register_onbackpressed";  //点击注册-返回
    public static final String CLICK_REGISTER_NEXT = "click_register_next";  //点击注册-下一步
    public static final String CLICK_FORGET_PWD = "click_forget_pwd";  //点击忘记密码1
    public static final String CLICK_FORGET_PWD_ONBACKPRESSED = "click_forget_pwd_onbackpressed";  //点击忘记密码-返回
    public static final String CLICK_FORGET_PWD_RESET_ONBACKPRESSED = "click_forget_pwd_reset_onbackpressed";  //点击忘记密码-设置密码-返回
    public static final String CLICK_FORGET_PWD_NEXT = "click_forget_pwd_next";  //点击忘记密码-下一步
    public static final String CLICK_FORGET_PWD_RESET_NEXT = "click_forget_pwd_reset_next_";  //点击忘记密码-设置密码-下一步

    /**
     * 友盟统计 个人中心 By yangmbin
     */
    public static final String EVENT_CANCEL_ORDER = "event_cancel_order"; // 点击取消订单按钮
    public static final String EVENT_CANCEL_ORDER_CONFIRM = "event_cancel_order_confirm"; // 点击取消订单确认按钮
    public static final String EVENT_ORDER_PAY = "event_order_pay"; // 点击订单中付款按钮
    public static final String EVENT_ORDER_REFUND = "event_order_refund"; // 点击申请退款按钮
    public static final String EVENT_ORDER_REFUND_SUBMIT = "event_order_refund_submit"; // 提交申请退款
    public static final String EVENT_ORDER_EXTEND_TIME = "event_order_extend_time"; // 点击延长收货
    public static final String EVENT_ORDER_CONFIRM = "event_order_confirm"; // 点击确认收货
    public static final String EVENT_ORDER_CONFIRM_SUBMIT = "event_order_confirm_submit"; // 确认收货确定按钮
    public static final String EVENT_ME_CENTER_COMMISSION = "event_me_center_commission"; // 点击个人中心我的奖励按钮
    public static final String EVENT_COMMISSION_SUBMIT = "event_commission_submit"; // 点击提取奖励按钮
    public static final String EVENT_COMMISSION_RULE = "event_commission_rule"; // 点击奖励规则按钮
    public static final String EVENT_INVITE_SPOKESMAN = "event_invite_spokesman"; // 邀请代言人点击分享按钮
    /** ============================ */
}
