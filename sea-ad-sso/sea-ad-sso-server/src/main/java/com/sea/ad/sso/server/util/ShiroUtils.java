package com.sea.ad.sso.server.util;

import com.sea.ad.modal.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lx48475
 * @version Id: ShiroUtils.java, v 0.1 2018年02月13 09:35 lx48475 Exp $
 */
public class ShiroUtils {

    private static final Logger logger = LoggerFactory.getLogger(ShiroUtils.class);

    /**
     * 获取当前登录的用户对象
     *
     * @return 用户对象
     */
    public static User getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        return (User) subject.getPrincipal();
    }

    /**
     * 获取当前的用户名
     *
     * @return 用户名, 无法获取是返回Unknown
     */
    public static String getCurrentUserName() {
        try {
            return getCurrentUser().getName();
        } catch (Exception e) {
            logger.error("Get current user's name error", e);
            return "Unknown";
        }
    }
}
