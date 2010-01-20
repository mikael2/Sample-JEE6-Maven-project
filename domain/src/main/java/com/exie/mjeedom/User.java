package com.exie.mjeedom;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mikael
 */
public class User implements Serializable {

    protected String name;
    protected Date birthDate;

    public User(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    

    /**
     * Get the value of birthDate
     *
     * @return the value of birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Set the value of birthDate
     *
     * @param birthDate new value of birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

}
