package com.exie.remotehandler;

import com.exie.mjeedom.MyServiceRemote;
import com.exie.hessian.HessianCookieProxyFactory;
import com.exie.mjeedom.ServiceFactory;
import java.net.MalformedURLException;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

import javax.jnlp.*;

/**
 *
 * @author mikael
 */
@ServiceProvider(service=ServiceFactory.class)
public class HessianServiceFactory implements ServiceFactory {
    static MyServiceRemote service;
    private String base;

    public HessianServiceFactory() {
        try {
            javax.jnlp.BasicService bs = (BasicService) ServiceManager.lookup("javax.jnlp.BasicService");
            String codeBase = bs.getCodeBase().toExternalForm();
            if ( !codeBase.endsWith( "/" ) ) {
                codeBase += "/";
            }

            System.out.println("Codebase: '" + codeBase + "'");
            int index = codeBase.lastIndexOf("webstart/");
            base = codeBase.substring(0, index) + "services/hessian/";
        } catch (UnavailableServiceException ex) {
            Exceptions.printStackTrace(ex);
            base = "http://localhost:8080/mjee-war/services/hessian/";
        }

        System.out.println("Base: '" + base + "'");
    }


    @Override
    public MyServiceRemote createMyServiceRemote() {
        if(service == null) {
            try {
                HessianCookieProxyFactory factory = new HessianCookieProxyFactory();
                String name =  base + MyServiceRemote.class.getName();
                service = (MyServiceRemote) factory.create(MyServiceRemote.class, name);
            } catch(MalformedURLException ex) {
                Exceptions.printStackTrace(ex);
            } catch(UnavailableServiceException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        return service;
    }
}
