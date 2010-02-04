package com.exie.services;

import com.exie.mjeedom.FlexService;
import com.exie.mjeedom.MyObject;

import javax.ejb.Stateless;
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
    public void saveObject(MyObject object) {
        LOG.info("Received object: " + object);
    }

    @Override
    public String ping() {
        return "pong";
    }
}
