package com.exie.web;

import com.caucho.hessian.server.HessianServlet;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mikael
 */
@WebFilter(filterName="HessianFilter", urlPatterns={"/services/hessian/*"})
public class HessianFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpReq = (HttpServletRequest) request;
	    //chain.doFilter(request, response);
            System.out.println("LocalAddr: " + request.getLocalAddr());
            System.out.println("RemoteAddr: " + request.getRemoteAddr());
            response.getWriter().print(
                    "<HTML><BODY> <br><b>LocalAddress:</b> " +
                    httpReq.getRequestURL() +
                    "</BODY></HTML>"
            );
    }

    @Override
    public void destroy() {
    }
}
