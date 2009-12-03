package com.exie.remotehandler;

import com.exie.domain.MyServiceRemote;
import com.exie.hessian.HessianCookieProxyFactory;
import java.net.MalformedURLException;
import org.openide.util.Exceptions;

/**
 *
 * @author mikael
 */
public class HessianUserHandler {
    static MyServiceRemote service;

    public static MyServiceRemote getService() {
        if(service == null) {
            try {
                HessianCookieProxyFactory factory = new HessianCookieProxyFactory();
                service = (MyServiceRemote) factory.create(MyServiceRemote.class, 
                        "http://localhost:8080/mjee-war");
            } catch (MalformedURLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        return service;
    }
}
