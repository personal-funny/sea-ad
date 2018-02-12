package com.sea.ad.sso.server.shiro;

import com.sea.ad.modal.User;
import com.sea.ad.sso.server.util.EncryptUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lx48475
 * @version Id: SSOCredentialsMatcher.java, v 0.1 2018年02月12 17:25 lx48475 Exp $
 */
@Component
public class SsoCredentialsMatcher implements CredentialsMatcher {

    @Autowired
    private EncryptUtils encryptUtils;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info) {
        // 真实的用户
        User user = (User) info.getPrincipals().getPrimaryPrincipal();
        String password = (String) info.getCredentials();
        // 用户提交的信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String rawPassword = new String(token.getPassword());
        // 加密
        String tempPassword = encryptUtils.getEncryptedPassword(rawPassword, user.getSalt());
        return StringUtils.equals(password, tempPassword);
    }
}