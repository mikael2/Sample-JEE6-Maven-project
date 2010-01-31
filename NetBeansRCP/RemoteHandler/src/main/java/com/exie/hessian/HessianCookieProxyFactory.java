package com.exie.hessian;

import com.caucho.hessian.client.HessianProxy;
import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.io.HessianRemoteObject;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.jnlp.BasicService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;

public class HessianCookieProxyFactory extends HessianProxyFactory {

    String base = "";

    public HessianCookieProxyFactory() throws UnavailableServiceException {
        BasicService bs = (BasicService) ServiceManager.lookup("javax.jnlp.BasicService");
        String codeBase = bs.getCodeBase().toExternalForm();
        if ( !codeBase.endsWith( "/" ) ) {
            codeBase += "/";
        }

        int index = codeBase.lastIndexOf("webstart/");
        base = codeBase.substring(0, index) + "services/hessian/";
    }


    public HessianCookieProxyFactory(String base) {
        this.base = base;
    }

    public Object create(Class api, String urlName, ClassLoader loader)
            throws MalformedURLException {
        URL url = new URL(urlName);

        HessianCookieProxy handler = new HessianCookieProxy(this, url);

        return Proxy.newProxyInstance(api.getClassLoader(),
                new Class[]{api, HessianRemoteObject.class}, handler);
    }

    public <T> T create(Class<T> api) throws MalformedURLException {
        return (T) create(api,base + api.getName(),api.getClassLoader());
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