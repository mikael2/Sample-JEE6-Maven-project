package com.exie.mjeedom;

import org.w3c.dom.Document;

import javax.ejb.Remote;

@Remote
public interface FlexService {
    MyObject getObject();
    boolean saveObject(MyObject object);
    String ping();
    Document getXml();
}
