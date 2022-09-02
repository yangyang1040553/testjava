package com.ruoyi.system.service;

import com.ruoyi.common.utils.GoogleAuthenticator;
import com.ruoyi.common.utils.SecurityUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

    public static void main(String[] args) {
        String s = SecurityUtils.encryptPassword("hash@#2022....");
        System.out.println(s);
        String secret = GoogleAuthenticator.genSecret("测试服账号");
        System.out.println(secret);
        String qrCode = GoogleAuthenticator.getQRBarcodeURL("测试服账号","Hash", secret);
        System.out.println(qrCode);

        boolean authcode = GoogleAuthenticator.authcode("642607", secret);
        System.out.println(authcode);
    }
}
