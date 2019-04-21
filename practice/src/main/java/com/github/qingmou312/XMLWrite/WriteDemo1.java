package com.github.qingmou312.XMLWrite;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Author:lidan
 * Created:2019/4/14
 */
public class WriteDemo1 {
    public static void main(String[] args) throws Exception {
        Document document = new SAXReader().read(WriteDemo1.class.getClassLoader().getResource("contact.xml"));

        OutputStream out = new FileOutputStream(new File("D:"));

        XMLWriter writer = new XMLWriter(out);

        writer.write(document);

        writer.close();
    }
}
