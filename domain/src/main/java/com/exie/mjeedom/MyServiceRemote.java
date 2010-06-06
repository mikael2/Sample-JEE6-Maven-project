package com.exie.mjeedom;

import javax.ejb.Remote;

/**
 * Testing inline edit
 *
 * @author mikael
 */
@Remote
public interface MyServiceRemote {
    String getHello(String name);
    String getUserHome();
    long ping();
}
