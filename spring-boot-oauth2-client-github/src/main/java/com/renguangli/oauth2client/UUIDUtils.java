package com.renguangli.oauth2client;

import java.util.UUID;

/**
 * UUIDUtils
 *
 * @author renguangli 2018/10/12 15:06
 * @since JDK 1.8
 */
public final class UUIDUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String uuid(int length) {
        if (length < 0 || length > 32) {
            throw new IndexOutOfBoundsException("length < 0 | length > 32");
        }
        return uuid().substring(0, length - 1);
    }

}
