package com.tjetc.empmanager.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "loginFilter",urlPatterns = "/manager/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        if (admin==null){
            request.setAttribute("message","sorry,you not login,please login you EAPlay");
            request.getRequestDispatcher("../login.jsp").forward(request,servletResponse);
        }
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
