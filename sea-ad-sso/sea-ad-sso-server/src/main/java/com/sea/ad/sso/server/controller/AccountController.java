package com.sea.ad.sso.server.controller;

import com.sea.ad.modal.User;
import com.sea.ad.sso.server.manager.UserManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author lx48475
 * @version Id: AccountController.java, v 0.1 2018年02月12 16:04 lx48475 Exp $
 */
@RestController
@RequestMapping("account")
@PropertySource("classpath:/sso.properties")
public class AccountController {

    @Autowired
    private UserManager userManager;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody User user) {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
            subject.login(token);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UserName or password error");
        }
    }

    @GetMapping("logout")
    public ResponseEntity logout() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        subject.logout();
        return ResponseEntity.ok().build();
    }
}
