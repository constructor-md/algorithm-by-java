package com.example.demo.designcode.patternbahavioral.mediator;

import java.util.Date;

/**
 *  中介者类
 *  具备一定方法，负责处理不同对象之间的通信
 */
public class ChatRoom {

    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() + "] " + message);
    }

}
