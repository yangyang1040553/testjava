package com.ruoyi.system.service;

import com.ruoyi.common.utils.SecurityUtils;

public class Test {

    public static void main(String[] args) {
        String s = SecurityUtils.encryptPassword("$Xy123456!");
        System.out.println(s);
    }
}
