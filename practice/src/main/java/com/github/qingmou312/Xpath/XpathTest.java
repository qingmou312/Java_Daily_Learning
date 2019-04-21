package com.github.qingmou312.Xpath;

/**
 * Author:lidan
 * Created:2019/4/14
 */


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模拟用户登录,
 * 用户输入用户名和密码,如果用户名不存在,提示用户名不存在,登录失败
 * 如果用户名存在,如果输入的密码不一致,提示,登录失败,密码错误,请重新输入!
 * <p>
 * xml可以作为小型数据库
 * 1)设计user.xml
 * <user-list>
 * <user id="1">
 * <name>lucy</name>
 * <password>123456</password>
 * </user>
 * ...
 * <p>
 * </user-list>
 * <p>
 * 2)键盘录入数据 (Scanner :文本扫描器/使用流的方式)
 * BufferedReader(new InputStreamReader(System.in)) ;   //将字节流--->字符流:字符转换流 InputStreamReader(inputStream,默认编码格式GBK)
 * 特有功能:一次读取一行: readLine
 * username/password
 * 3)使用解析器对象SAXReader读取文件 --->document
 * Node nameNode <-- 使用xpath定位:不分层级关系的user标签下的name标签的文本  = username
 * 如果节点不存在,提示登录失败
 * 存在
 * 判断用输入的password和user.xml(数据库)中password的内容是否一致
 * 一致,登录成功
 * 不一致,提示信息
 */


public class XpathTest {
    public static void main(String[] args) throws IOException, DocumentException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name = br.readLine();
        System.out.println("请输入密码：：");
        String password = br.readLine();

        Document document = new SAXReader().read(XpathTest.class.getClassLoader().getResource(""));

//        Element nameElem = document.selectSingleNode();

    }
}
