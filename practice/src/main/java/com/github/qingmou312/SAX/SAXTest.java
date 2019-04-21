package com.github.qingmou312.SAX;

/**
 * Author:lidan
 * Created:2019/4/14
 */

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;


/**
 * SAX解析--》针对事件编程
 * 三要素：
 *  1.事件源：xml文件
 *  2.事件监听器：
 *      遇到文档开始
 *          startDocument()
 *      遇到开始标签
 *          startElement()
 *      遇到文本内容
 *          characters()
 *      遇到结束标签
 *          endElement()
 *      文档结束
 *          endDocument()
 *  3.注册事件监听器：基于事件处理程序
 *
 * 开发步骤：
 * 1.创建SAX解析对象
 * 2.解析当前XMl文件
 * 3.基于事件处理进行判断（开始标签/结束标签/文本内容）
 */
public class SAXTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1.创建一个SAX解析对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        //2.读取XML文件
        //事件源
        parser.parse(SAXTest.class.getClassLoader().getResourceAsStream(""),new MyDefaultHandler1());



    }
}
