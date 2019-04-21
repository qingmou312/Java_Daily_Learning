package com.github.qingmou312.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Author:lidan
 * Created:2019/4/19
 */
public class MyDefaultHandler2 extends DefaultHandler {

    //遇到开始标签
    //qName：标签名称
    //attributes:属性列表
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("解析开始");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    //文本内容
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }
}
