package com.ruoyi.system.service;

import com.aliyun.oss.common.utils.HttpUtil;
import com.ruoyi.common.utils.GoogleAuthenticator;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Test2 {

    static String url = "https://www.xhsxsw.com/html/94938/108500676.html";

    public static void main(String[] args) throws IOException, InterruptedException {
        String s = HttpUtils.sendGet(url);
//        System.out.println("sss-=>" + s);

        Document parse = Jsoup.parse(s);
        Element content = parse.getElementById("content");
        String html = content.html();
        html = html.replace("<br>", "");
        html = html.replace("<p>", "   ");
        html = html.replace("</p>", "");

        System.out.print(html);
//        String str = html;
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < html.length(); i++) {
//            if (i < html.length() - 1000) {
//                list.add(str.substring(i, i + 100));
//                i = i + 300;
//            } else {
//                list.add(str.substring(i));
//            }
//        }
//
//        for (String xk : list) {
//            System.out.println(xk);
//        }


    }
}
