package com.exie.mjeedom;

import javax.ejb.Remote;

@Remote
public interface FlexService {
    MyObject getObject();
    void saveObject(MyObject object);
    String ping();
}
