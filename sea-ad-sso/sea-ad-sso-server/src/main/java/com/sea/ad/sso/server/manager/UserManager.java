package com.sea.ad.sso.server.manager;

import com.sea.ad.modal.User;
import org.springframework.stereotype.Service;

/**
 * @author lx48475
 * @version Id: UserManager.java, v 0.1 2018年02月12 15:58 lx48475 Exp $
 */
@Service
public class UserManager {

//    @Autowired
//    private UserMapper userMapper;

    public User getUserByLoginName(String loginName) {
//        return userMapper.getUserByLoginName(loginName);
        return new User();
    }
}
