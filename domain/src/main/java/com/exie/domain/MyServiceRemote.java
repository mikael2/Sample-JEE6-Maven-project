package com.exie.domain;

import javax.ejb.Remote;

/**
 * Testing inline edit
 *
 * @author mikael
 */
@Remote
public interface MyServiceRemote {
    String getHello(String name);
}
