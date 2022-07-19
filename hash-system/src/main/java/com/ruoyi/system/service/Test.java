package com.ruoyi.system.service;

import com.ruoyi.common.utils.SecurityUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

    public static void main(String[] args) {
//        String s = SecurityUtils.encryptPassword("$Xy123456!");
//        System.out.println(s);
        try {
            InetAddress byName = InetAddress.getByName("imapi4.yii888.cc");
            System.out.println("byName=="+byName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
