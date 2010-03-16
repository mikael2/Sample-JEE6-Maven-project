package com.exie.web;

import com.exie.mjeedom.MyServiceRemote;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mikael
 */
@ManagedBean(name="MyJSPManagedBean")
@SessionScoped
public class MyJSPManagedBean {
    @EJB MyServiceRemote service;

    /** Creates a new instance of MyJSPManagedBean */
    public MyJSPManagedBean() {
        System.out.println("MyJSPManagedBean test");
    }

    public MyServiceRemote getService() {
        return service;
    }
}
