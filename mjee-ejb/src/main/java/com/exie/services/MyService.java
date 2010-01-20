package com.exie.services;

import com.exie.mjeedom.MyServiceRemote;
import com.exie.mjeedom.User;
import com.exie.scalalib.UserFactory;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author mikael
 */
@Stateless
public class MyService implements MyServiceRemote {
    Map<String,User> users = new HashMap<String, User>();

    public String getHello(String name) {
        User user = users.get(name);

        if(user != null) {
            // user = new User(name, new Date());
            user = UserFactory.createUser(name, new Date());
        }

        return "Hello " + user;
    }


    public long ping() {
        return System.currentTimeMillis();
    }
}
