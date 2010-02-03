package com.exie.remotehandler;

import com.exie.hessian.HessianCookieProxyFactory;
import com.exie.mjeedom.ServiceFactory;
import java.net.MalformedURLException;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author mikael
 */
@ServiceProvider(service=ServiceFactory.class)
public class HessianServiceFactory implements ServiceFactory {
    private String base;

    public HessianServiceFactory() {
       base = "http://localhost:8080/mjee-web/services/hessian/";
    }


    public <T> T create(Class<T> api) {
        T service = null;

        HessianCookieProxyFactory factory = null;
        try {
            factory = new HessianCookieProxyFactory();
        } catch(Throwable e) {
            factory = new HessianCookieProxyFactory(base);
        }

        if(factory != null) {
            try {
                service = factory.create(api);
            } catch (MalformedURLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        return service;
    }

}
