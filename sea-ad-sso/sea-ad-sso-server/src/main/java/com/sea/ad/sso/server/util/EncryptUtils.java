package com.sea.ad.sso.server.util;

import com.sea.ad.sso.server.autoconfigure.SsoProperties;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author lx48475
 * @version Id: EncodeUtils.java, v 0.1 2018年02月12 17:26 lx48475 Exp $
 */
@Component
public class EncryptUtils {

    @Autowired
    private SsoProperties properties;

    /**
     * 生成私有盐
     *
     * @return 返回uuid字符串
     */
    public String getRandomSalt() {
        return UUID.randomUUID().toString();
    }

    /**
     * 先用全局盐md5加密一次, 再用私有盐sha256加密一次
     *
     * @param rowPassword 明文密码
     * @param selfSalt    私有盐
     *
     * @return 加密后的密码
     */
    public String getEncryptedPassword(String rowPassword, String selfSalt) {
        String temp = DigestUtils.md5Hex(rowPassword + properties.getEncrypt().getSalt());
        return DigestUtils.sha256Hex(temp + selfSalt);
    }

}