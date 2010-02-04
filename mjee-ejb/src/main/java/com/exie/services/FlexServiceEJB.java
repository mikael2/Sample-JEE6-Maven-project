package com.exie.services;

import com.exie.mjeedom.FlexService;
import com.exie.mjeedom.MyObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.ejb.Stateless;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.logging.Logger;

@Stateless
public class FlexServiceEJB implements FlexService {
    private static final Logger LOG = Logger.getLogger(FlexServiceEJB.class.getName());

    @Override
    public MyObject getObject() {
        MyObject myObject = new MyObject();
        myObject.id = "foo";
        myObject.value = "bar";
        return myObject;
    }

    @Override
    public boolean saveObject(MyObject object) {
        LOG.info("Received object: " + object);
        return true;
    }

    @Override
    public String ping() {
        return "pong";
    }

    @Override
    public Document getXml() {
        try {
            Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = d.createElement("root");
            d.appendChild(root);
            root.appendChild(d.createElement("a"));
            root.appendChild(d.createElement("b"));
            return d;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Unable to create XML.");
        }
    }
}
