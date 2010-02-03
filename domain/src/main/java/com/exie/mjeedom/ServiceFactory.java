package com.exie.mjeedom;

/**
 *
 * @author mikael
 */
public interface ServiceFactory {
    public <T> T create(Class<T> api);
}
