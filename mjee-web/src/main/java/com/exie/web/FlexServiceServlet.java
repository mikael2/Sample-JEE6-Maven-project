package com.exie.web;

import com.caucho.hessian.server.HessianServlet;
import com.exie.mjeedom.FlexService;
import com.exie.mjeedom.MyObject;

import javax.ejb.EJB;

public class FlexServiceServlet extends HessianServlet implements FlexService {
    @EJB
    private FlexService delegate;

    @Override
    public MyObject getObject() {
        return delegate.getObject();
    }

    @Override
    public void saveObject(MyObject object) {
        delegate.saveObject(object);
    }

    @Override
    public String ping() {
        return delegate.ping();
    }
}
