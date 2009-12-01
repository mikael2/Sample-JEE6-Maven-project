package com.exie.hessian;

import com.caucho.hessian.client.HessianProxy;
import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.io.HessianRemoteObject;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;



/**
 *
 * @author mikael
 */
public class HessianCookieProxyFactory extends HessianProxyFactory {

    public Object create(Class api, String urlName, ClassLoader loader)
            throws MalformedURLException {
        URL url = new URL(urlName);

        HessianCookieProxy handler = new HessianCookieProxy(this, url);

        return Proxy.newProxyInstance(api.getClassLoader(),
                new Class[]{api, HessianRemoteObject.class}, handler);
    }

    private static class HessianCookieProxy extends HessianProxy {

        /** List of cookies */
        private List<String> cookieStrings = null;

        HessianCookieProxy(HessianProxyFactory factory, URL url) {
            super(url, factory);
        }

        protected void parseResponseHeaders(URLConnection conn) {
            List<String> cookies = conn.getHeaderFields().get("Set-Cookie");
            if (cookies != null) {
                cookieStrings = cookies;
            }
        }

        protected void addRequestHeaders(URLConnection conn) {
            if (cookieStrings != null) {
                for (String cookieString : cookieStrings) {
                    conn.setRequestProperty("Cookie", cookieString);
                }
            }
        }
    }
}
