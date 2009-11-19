package com.exie.services;

import com.exie.domain.MyServiceRemote;
import javax.ejb.Stateless;

/**
 *
 * @author mikael
 */
@Stateless
public class MyService implements MyServiceRemote {
    public String getHello(String name) {
        return "Hello " + name;
    }


    public long ping() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
