package com.guinong.lib_utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/27.
 * 关于密码设置的工具类
 */
public class PasswordUtil {
    public static final int PWD_MIN_LENGTH=6;
    public static final int PWD_MAX_LENGTH=18;
    //密码规则
    private static final String PASSWORD_MATCH_REGX = "^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{6,20}$";


    /**
     * 判断是否是符合规则的密码
     *
     **/
    public static boolean isOkPwd(String password) {

        Pattern p = Pattern.compile(PASSWORD_MATCH_REGX);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
