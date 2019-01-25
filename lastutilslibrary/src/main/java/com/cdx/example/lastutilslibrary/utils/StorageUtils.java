package com.cdx.example.lastutilslibrary.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    private StorageUtils() {
    }

    /**
     * 获取缓存文件
     * @param context 上下文
     * @return 返回的缓存文件
     */
    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    /**
     * 获取缓存文件
     * @param context 上下文
     * @param preferExternal
     * @return
     */
    public static File getCacheDirectory(Context context, boolean preferExternal) {
        //逻辑
        //1、判断外部存储是否可用，并且是否有外部存储的权限，那么就在外部存储中创建文件
        File var2 = null;
        if (preferExternal && "mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            var2 = getExternalCacheDir(context);
        }
        //2、如果外部存储中没有创建文件，那么就获得内部存储的缓存文件。
        if (var2 == null) {
            var2 = context.getCacheDir();
        }
        //3、如果内不能存储不能创建，那么就固定的地方进行创建。
        if (var2 == null) {
            String var3 = "/data/data/" + context.getPackageName() + "/cache/";
            var2 = new File(var3);
        }

        return var2;
    }

    public static File getFilesDirectory(Context context) {
        return getFilesDirectory(context, true);
    }

    public static File getFilesDirectory(Context context, boolean preferExternal) {
        File var2 = null;
        if (preferExternal && "mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            var2 = getExternalFilesDir(context);
        }

        if (var2 == null) {
            var2 = context.getFilesDir();
        }

        if (var2 == null) {
            String var3 = "/data/data/" + context.getPackageName() + "/files/";
            var2 = new File(var3);
        }

        return var2;
    }

    public static File getIndividualCacheDirectory(Context context) {
        File var1 = getCacheDirectory(context);
        File var2 = new File(var1, "uil-images");
        if (!var2.exists() && !var2.mkdir()) {
            var2 = var1;
        }

        return var2;
    }

    public static File getOwnCacheDirectory(Context context, String cacheDir) {
        File var2 = null;
        if ("mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            var2 = new File(Environment.getExternalStorageDirectory(), cacheDir);
        }

        if (var2 == null || !var2.exists() && !var2.mkdirs()) {
            var2 = context.getCacheDir();
        }

        return var2;
    }

    private static File getExternalCacheDir(Context context) {
        File var1 = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File var2 = new File(new File(var1, context.getPackageName()), "cache");
        if (!var2.exists()) {
            if (!var2.mkdirs()) {
                return null;
            }
            try {
                (new File(var2, ".nomedia")).createNewFile();
            } catch (IOException var4) {

            }
        }

        return var2;
    }

    private static File getExternalFilesDir(Context context) {
        File var1 = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File var2 = new File(new File(var1, context.getPackageName()), "files");
        if (!var2.exists()) {
            if (!var2.mkdirs()) {
                return null;
            }

            try {
                (new File(var2, ".nomedia")).createNewFile();
            } catch (IOException var4) {
            }
        }

        return var2;
    }

    /**
     * 判断是否拥有存储权限
     * @param context 上下文
     * @return 是否含有存储权限
     */
    private static boolean hasExternalStoragePermission(Context context) {
        int var1 = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        return var1 == 0;
    }
}
