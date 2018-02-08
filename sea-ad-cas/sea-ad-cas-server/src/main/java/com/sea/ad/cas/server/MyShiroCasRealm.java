package com.sea.ad.cas.server;

import com.sea.ad.modal.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author lx48475
 * @version Id: MyShiroCasRealm.java, v 0.1 2018年02月07 15:19 lx48475 Exp $
 */
public class MyShiroCasRealm extends AuthorizingRealm {

    public MyShiroCasRealm() {
        setName("MyShiroCasRealm");
    }

    private static final Logger logger = LoggerFactory.getLogger(MyShiroCasRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        if (Objects.isNull(token)) {
            throw new AuthenticationException("用户不存在");
        }
        User user = new User();
        return new SimpleAuthenticationInfo(user.getId(), user.getName(), getName());
    }
}
