package com.github.qingmou312.Test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:lidan
 * Created:2019/4/14
 */
public class Dom4j_Test {
    public static void main(String[] args) throws DocumentException {
        List<Contact> contacts = new ArrayList<Contact>();

        Document document = new SAXReader().read(Dom4j_Test.class.getClassLoader().getResource("contact.xml"));

        Element rootElement = document.getRootElement();

        List<Element> elements = rootElement.elements("contact");

        for (Element conElem : elements) {
            Contact contact = new Contact();
            contact.setId(conElem.attributeValue("id"));
            contact.setName(conElem.elementText("name"));
            contact.setTel(conElem.elementText("tel"));
            contact.setAddress(conElem.elementText("address"));
            contacts.add(contact);
        }

        for(Contact con:contacts){
            System.out.println(con);
        }

    }
}
