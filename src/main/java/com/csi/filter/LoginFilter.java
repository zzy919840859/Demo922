package com.csi.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        if (admin==null){
            request.setAttribute("message","请先登陆，在访问");
            request.getRequestDispatcher("../login.jsp").forward(request,servletResponse);
        }
        filterChain.doFilter(request,servletResponse);
    }

    public boolean getAddress(HttpServletRequest request){
        String path = request.getContextPath();
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        System.out.println(url);
        String referer = request.getHeader("referer");
        System.out.println(referer);
        return referer!=null&&referer.startsWith(url);
    }

    @Override
    public void destroy() {

    }
}
