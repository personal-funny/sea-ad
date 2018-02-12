package com.sea.ad.sso.server.controller;

import com.sea.ad.sso.server.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lx48475
 * @version Id: UserController.java, v 0.1 2018年02月12 16:02 lx48475 Exp $
 */
@RestController
@RequestMapping(value = "account/users")
public class UserController {

    @Autowired
    private UserManager userManager;

}
