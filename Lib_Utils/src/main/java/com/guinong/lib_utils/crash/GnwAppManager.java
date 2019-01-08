package com.guinong.lib_utils.crash;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;

import java.util.Stack;


/**
 * @author chenshuangniu
 * @time 2016/11/14 0014 9:14
 * @修改内容 管理类
 * @版本 1.0
 */
public class GnwAppManager {
    private static GnwAppManager mInstance;
    private static Stack<Activity> mActivityStack;
    private Context context;
    private GnwAppManager(Context context) {
        this.context = context;
    }

    public static synchronized GnwAppManager getInstance(Context context) {//单例
        if (mInstance == null) {
            mInstance = new GnwAppManager(context);
        }
        return mInstance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    /**
     * 获取栈顶Activity（堆栈中最后一个压入的）
     */
    public Activity getTopActivity() {
        Activity activity = mActivityStack.lastElement();
        return activity;
    }

    /**
     * 结束栈顶Activity（堆栈中最后一个压入的）
     */
    public void killTopActivity() {
        Activity activity = mActivityStack.lastElement();
        killActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void killActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void killActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                killActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void killAllActivity() {
        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            if (mActivityStack.get(i) != null) {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }

    /**
     * 退出应用程序
     */
    @SuppressWarnings("deprecation")
    public void AppExit() {
        try {
            killAllActivity();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }

    /**
     * 除了主页都关闭
     **/
    /*public void finishActivityExceptMain() {
        List<Activity> activityList = new ArrayList<>();
        for (Activity activity : mActivityStack) {

            if (!activity.getClass().equals(MainActivity.class)) {
                activityList.add(activity);
                activity.finish();
            }
        }
        mActivityStack.removeAll(activityList);
    }*/

    /**
     * 除了登录页都关闭
     **/
   /* public void finishActivityExceptLogin() {
        List<Activity> activityList = new ArrayList<>();
        for (Activity activity : mActivityStack) {
            if (!activity.getClass().equals(LoginActivity.class)) {
                activityList.add(activity);
                activity.finish();
            }
        }
        mActivityStack.removeAll(activityList);
    }*/

    /**
     * 顶栈是否是mainactivity
     **/
    /*public boolean isMainActivity() {
        if (getTopActivity().equals(MainActivity.class)) {
            return true;
        } else {
            return false;
        }
    }*/

    /**
     * 是否在前台运行
     **/
    public boolean isRunningForeground(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        String currentPackageName = cn.getPackageName();
        if (!TextUtils.isEmpty(currentPackageName) && currentPackageName.equals(context.getPackageName())) {
            return true;
        }
        return false;
    }
}
