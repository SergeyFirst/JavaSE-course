package com.company.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {

        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hresp = (HttpServletResponse) resp;
        try {
            Object attribute = hreq.getSession().getAttribute("ACCESSED");
            if ((attribute != null) && (attribute.equals(true))) {
                chain.doFilter(req, resp);
            } else {
                hresp.sendRedirect(hreq.getContextPath()+"/");
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
