package com.github.qingmou312.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Author:lidan
 * Created:2019/4/14
 */

/**
 * 编写监听器：自定义类  继承自基类（DefaultHandler）
 */
public class MyDefaultHandler1 extends DefaultHandler {

    /**
     * 文本触发事件
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //遇到文本：每次读取的是当前文本的实际内容
        String content = new String(ch, start, length);

    }

    /**
     * 开始元素的触发事件
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler1.startElement:"+qName);
    }


    /**
     * 结束标签触发的一个事件
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }
}
