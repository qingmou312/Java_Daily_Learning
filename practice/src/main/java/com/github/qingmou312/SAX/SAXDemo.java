package com.github.qingmou312.SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Author:lidan
 * Created:2019/4/19
 * <p>
 * 需求:将contact.xml文件原封不动的输出:使用SAX解析
 * 1)	创建解析器
 * 2)	读取contact.xml文件
 * <p>
 * 3)	定义一个基于事件的处理程序(一个类 extends DefaultHandler)
 * 使用字符串缓存区对象StringBuffer
 * 定义一个方法---->可以将字符串缓存区的内容--->String类型
 * public String getContent(){StringBuffer.toString()}
 * 开始标签startElement(String qName ,Atrributes attributes)
 * sb.append(“<”+qName) ;   //<concat id=”001”>
 * 遍历属性列表
 * getValue()/getName()
 * <p>
 * sb.append(属性名称=value)
 * <p>
 * 文本内容
 * String(ch,start,length) ;
 * <p>
 * 结束标签
 * Sb.append(“</”+qName+”>”);
 */
public class SAXDemo {
    public static void main(String[] args) throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(SAXDemo.class.getClassLoader().getResourceAsStream("contact.xml"), new MyDefaultHandler2());

    }

}
