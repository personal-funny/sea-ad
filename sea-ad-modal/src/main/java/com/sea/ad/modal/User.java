package com.sea.ad.modal;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lx48475
 * @version Id: User.java, v 0.1 2018年02月07 15:38 lx48475 Exp $
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 6928133223111103727L;

    private long   id;
    private String name;
    private String password;
    private String salt;
    private String desc;
}
