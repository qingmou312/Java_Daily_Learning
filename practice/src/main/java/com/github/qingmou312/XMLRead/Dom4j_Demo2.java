package com.github.qingmou312.XMLRead;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Author:lidan
 * Created:2019/4/14
 *
 * 1.获取根节点：
 * 2.获取第一个子节点对象；根节点对象.element("")
 * 3.
 *
 */
public class Dom4j_Demo2 {
    public static void main(String[] args) throws DocumentException {
        /**
         * 1.获取文件
         */
        Document document = new SAXReader().
                read(Dom4j_Demo2.class.getClassLoader().getResource("contact.xml"));

        /**
         * 2.获取标签对象
         * 2.1 获取根标签对象
         * Element getRootElement();
         */

        Element rootElem = document.getRootElement();

        System.out.println(rootElem);


        /**
         * getText()获取文本内容
         *
         * 在xml文件中，空格和换行是能解析
         */


        /**
         * 获取标签名称：Element里面的getName():获取标签名称
         */

        /**
         * 2.4：elements():通过根节点对象获取所有的子节点对象
         */
        List<Element> list=rootElem.elements();
    }
}
