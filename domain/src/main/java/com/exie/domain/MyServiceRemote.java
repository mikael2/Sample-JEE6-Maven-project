package com.exie.domain;

import javax.ejb.Remote;

/**
 *
 * @author mikael
 */
@Remote
public interface MyServiceRemote {
    String getHello(String name);
}
