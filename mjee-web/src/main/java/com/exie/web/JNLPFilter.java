package com.exie.web;

import com.exie.mjeedom.MyServiceRemote;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mikael
 */
public class JNLPFilter implements Filter {
    @EJB
    MyServiceRemote service;

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ServletOutputStream sos = response.getOutputStream();
        CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse)response);
        chain.doFilter(request, wrapper);

        String result = wrapper.toString();
        String pattern = "(<property name=\"netbeans.user\" value=\"\\$\\{user.home\\}/).mjeercp(\"/>)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(result);
        result = m.replaceFirst("$1.mjee/" + service.getUserHome() + "$2");

        response.setContentLength(result.length());
        byte[] res = request.getCharacterEncoding() != null ?
                     result.getBytes(request.getCharacterEncoding()) :
                     result.getBytes();

        sos.write(res);
        sos.close();
    }

    public void destroy() {
    }
}
