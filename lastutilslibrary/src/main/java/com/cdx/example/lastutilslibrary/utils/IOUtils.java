package com.cdx.example.lastutilslibrary.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 */
public class IOUtils {
    /**
     * 关闭流
     */
    public static boolean close(Closeable... ios) {
        for (Closeable io : ios) {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException e) {
                }
            }
        }
        return true;
    }
}
