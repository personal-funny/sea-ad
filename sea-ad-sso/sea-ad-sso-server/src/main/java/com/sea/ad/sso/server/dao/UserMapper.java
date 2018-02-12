package com.sea.ad.sso.server.dao;

import com.sea.ad.modal.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lx48475
 * @version Id: UserMapper.java, v 0.1 2018年02月12 15:46 lx48475 Exp $
 */
@Repository
public interface UserMapper {

    User getUserByLoginName(@Param("loginName") String loginName);
}
