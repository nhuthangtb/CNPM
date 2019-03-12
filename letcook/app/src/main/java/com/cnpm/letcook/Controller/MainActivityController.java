package com.cnpm.letcook.Controller;

import com.cnpm.letcook.Model.User;

public class MainActivityController {

    User user ;

    public MainActivityController() {
        user = new User();
    }

    public String getInfoUser(){
        return user.getInfoUser();
    }
}
