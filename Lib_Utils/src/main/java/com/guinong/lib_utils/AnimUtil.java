package com.guinong.lib_utils;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 属性动画工具类
 * @author ymb
 * Create at 2017/5/31 14:05
 */
public class AnimUtil {
    /**
     * 旋转动画
     */
    public static void rotateView0To180(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "rotation", 0f, 180f);
        animator.setDuration(300);
        animator.start();
    }

    /**
     * 旋转动画
     */
    public static void rotateView180To0(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "rotation", 180f, 0f);
        animator.setDuration(300);
        animator.start();
    }
}
