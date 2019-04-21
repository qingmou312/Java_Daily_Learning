package com.github.qingmou312.XMLRead;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * Author:lidan
 * Created:2019/4/14
 */
public class Dom4j_Demo1 {
    public static void main(String[] args) {
        //1.创建DOM解析对象
        SAXReader reader = new SAXReader();
        //2.读取当前resources目录下的contact.xml文件
        //读取文件的时候：1)使用绝对路径   2)类加载器的方式获取当前目录地址
        try {
            Document document = reader.read(Dom4j_Demo1.class.getClassLoader().getResource("contact.xml"));

            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}
