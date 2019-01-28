package com.cdx.example.lastutilslibrary.utils;

/**
 * 判断是否快速点击的工具类
 */
public class FastClickUtil {

    public static final int MIN_DELAY_TIME= 500;  // 两次点击间隔不能少于500ms
    private static long lastClickTime; //上一次点击的时间

    /**
     * 判断是否快速点击
     * @return true:快速点击,false：不是快速点击
     */
    public static boolean isFastClick() {
        //1、默认是快速点击
        boolean flag = true;
        //2、如果当前点击的时间和上一件点击的时间 大于 500毫秒，说明就不是快速点击。
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = false;
        }
        //3、记录下当前的时间
        lastClickTime = currentClickTime;
        return flag;
    }
}
