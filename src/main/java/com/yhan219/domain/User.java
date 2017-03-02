package com.yhan219.domain;

import java.io.Serializable;

/**
 * Created by yhan219 on 2017/2/12.
 */
public class User implements Serializable {

    private String id;

    private String username;

    private String password;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String tel) {
        this.phone = tel;
    }
}
