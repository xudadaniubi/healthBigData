package com.boku.www.utils;

import java.util.UUID;

/**
 * Created by Administrator on 2019/6/29.
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
