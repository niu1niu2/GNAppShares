package com.guinong.lib_commom.utils;


import com.guinong.lib_commom.GNCommonApplication;
import com.guinong.lib_utils.cache.ACache;

/**
 * 缓存工具类，使用ASimpleCache进行缓存
 * 注意事项：如果存储类对象，类和类中的内部类都需要实现Serializable接口
 * @author yangmbin
 * Create at 2017/11/30 16:48
 */
public class CacheUtil {
    private static final String TOP_CATEGORY_KEY = "top_category_key";
    private static final String TWO_THREE_CATEGORY_KEY = "two_three_category_key";
    private static final String SHOPPING_MALL_KEY = "shopping_mall_key";
    private static final String VENUE_LIST = "venue_list";
    private static final String VOLUNTEER_ACTIVE_LIST = "volunteer_active_list";
    private static final String VOLUNTEER_ACTIVE_BANNER_LIST = "volunteer_active_banner_list";

    /**
     * 获取缓存key
     * @param prefix
     * @param param
     * @return
     */
    public static String getCacheKey(String prefix, long param) {
        return prefix + Long.toString(param);
    }

    /**
     * 获取缓存目录，getExternalCacheDir()或getCacheDir()
     * @return
     */
    public static String getCacheDir() {
        return ACache.getDiskCacheDir(GNCommonApplication.getApplicaContext());
    }

}
