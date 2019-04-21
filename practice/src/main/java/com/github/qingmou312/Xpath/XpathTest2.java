package com.github.qingmou312.Xpath;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Author:lidan
 * Created:2019/4/14，，，
 */
public class XpathTest2 {
    public static void main(String[] args) throws Exception {

        SAXReader reader = new SAXReader();

        Document document = reader.read(new File(""));

        Element titleElem = (Element) document.selectSingleNode("");

        System.out.println(titleElem.getText());

        List<Element> trElem = document.selectNodes("//body/tr");

        for (Element e : trElem) {
            String id = e.selectSingleNode("td[1]").getText();
            String name = e.selectSingleNode("td[2]").getText();


            System.out.println(id + name);
        }
    }
}
