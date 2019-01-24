package com.cdx.example.lastutilslibrary.utils;

import android.content.Context;

/**
 * 屏幕相关的工具类
 */
public class ScreenUtils {

    /**
     * getDisplayMetrics()用来获取屏幕参数
     */

    public static final int SCREEN_ORIENTATION_HORIZONTAL = 2;//横向
    public static final int SCREEN_ORIENTATION_VERTICAL = 1;//纵向
    public static final int NOT_COMPUTE = -1;//没有办法计算

    /**
     * 获取设置的绝对宽度,单位是px
     */
    public static int getWidthPixels(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    /**
     * 获取设置的绝对高度，单位是px
     */
    public static int getHeightPixels(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    /**
     * 获得屏幕每英寸的点数（屏幕密度）
     */
    public static int getDensityDpi(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().densityDpi;
        }
        return 0;
    }

    /**
     * 获得屏幕的逻辑密度，这个一个和密度无关的像素单位。
     * 获得密度比。
     */
    public static float getDensity(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().density;
        }
        return 0;
    }

    /**
     * 获取屏幕中显示在显示器上的字体的比例因子
     */
    public static float getScaledDensity(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().scaledDensity;
        }
        return 0;
    }

    /**
     * 获得屏幕的方向
     *
     * @param context
     * @return 1:纵向 2：横向 -1：没有办法计算
     */
    public static int getOrientation(Context context) {
        if (context != null) {
            int widthPixels = getWidthPixels(context);
            int heightPixels = getHeightPixels(context);
            if (heightPixels > widthPixels) {
                return SCREEN_ORIENTATION_VERTICAL;
            } else {
                return SCREEN_ORIENTATION_HORIZONTAL;
            }
        } else {
            return NOT_COMPUTE;
        }
    }

}
