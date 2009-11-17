package com.exie.web;

import com.exie.domain.MyServiceRemote;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mikael
 */
@ManagedBean(name="MyJSPManagedBean")
@SessionScoped
public class MyJSPManagedBean {

    /** Creates a new instance of MyJSPManagedBean */
    public MyJSPManagedBean() {
        System.out.println("MyJSPManagedBean");
    }

    public MyServiceRemote getService() {
        return null;
    }
}
