package cn.wayok.enums;

import java.math.BigInteger;
import java.util.UUID;
import org.springframework.util.DigestUtils;

/**
 * @author icelo
 * @date 2021/10/4
 */
public enum EntityId {

    SHORT_URL;


    private static final String JOINER = "_";

    private static String getMD5(String str) {
        //比如对密码进行 md5 加密
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    private static String join(String prefix, String id) {
        return prefix + JOINER + id;
    }

    private static String generalId() {
        return getMD5(UUID.randomUUID().toString());
    }

    public String id() {
        return join(this.name(), generalId());
    }

    public String id(Object object) {
        return join(this.name(), generalId());
    }

}
