package com.exie.mjeedom;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class MyObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement public String id;
    @XmlElement public String value;

    @Override
    public String toString() {
        return "MyObject[id=" + id + ", value=" + value + "]";
    }
}
