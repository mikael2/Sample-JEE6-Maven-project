package com.exie.services;

import com.exie.mjeedom.MyServiceRemote;
import com.exie.mjeedom.User;
import com.exie.scalalib.UserFactory;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.prefs.Preferences;
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

        if(user == null) {
            // user = new User(name, new Date());
            user = UserFactory.createUser(name, new Date());
            users.put(name, user);
        }

        return "Hello " + user.getName();
    }


    public long ping() {
        return System.currentTimeMillis();
    }

    public String getUserHome() {
        Preferences p = Preferences.userNodeForPackage(MyService.class);
        String retVal = p.get("uuid", UUID.randomUUID().toString());

        System.out.println("getUserHome: '" + retVal + "'");

        return retVal;
    }
}
