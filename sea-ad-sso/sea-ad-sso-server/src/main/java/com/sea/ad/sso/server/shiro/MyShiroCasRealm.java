package com.sea.ad.sso.server.shiro;

import com.sea.ad.modal.User;
import com.sea.ad.sso.server.manager.UserManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author lx48475
 * @version Id: MyShiroCasRealm.java, v 0.1 2018年02月07 15:19 lx48475 Exp $
 */
@Component
public class MyShiroCasRealm extends AuthorizingRealm {

    @Autowired
    private UserManager userManager;

    public MyShiroCasRealm() {
        setName("MyShiroCasRealm");
    }

    private static final Logger logger = LoggerFactory.getLogger(MyShiroCasRealm.class);

    /**
     * 获取用户角色以及角色对应的权限
     *
     * @param principals 用户角色
     *
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user  = (User) principals.getPrimaryPrincipal();
        Set<String> roles = new HashSet<>(); // roleService.getUserRolesByUserName(user.getUserName());
        Set<String> permissions = new HashSet<>();
//        for (String role : roles) {
//            Set<String> perms = permissionService.getPermissionsByRoleName(role);
//            permissions.addAll(perms);
//        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 进行用户登录
     *
     * @param authcToken 用户登录的token
     *
     * @return
     *
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        if (Objects.isNull(token)) {
            throw new AuthenticationException("用户不存在");
        }
        User user = new User();
        user.setId(1);
        user.setName(token.getUsername());
        user.setPassword(token.getCredentials().toString());
        user.setDesc(token.getHost() + " - " + token.isRememberMe());
        return new SimpleAuthenticationInfo(user, "bd2bac962abe04b1888311c7f299a8546d70dc42d30070810e3f238bbaf1c225", getName());
    }
}
