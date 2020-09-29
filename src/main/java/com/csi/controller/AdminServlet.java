package com.csi.controller;


import com.csi.domain.Admin;
import com.csi.domain.Product;
import com.csi.service.AdminService;
import com.csi.service.ProductService;
import com.csi.service.impl.AdminServiceImpl;
import com.csi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    AdminService as = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        String op = req.getParameter("op");
        if ("login".equals(op)){
            this.login(req,resp);
        }else if ("reset".equals(op)){
            this.reset(req,resp);
        }



    }

    private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("admin");
        req.setAttribute("message","注销成功,请重新登陆");
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Admin admin = as.login(account,password);
        if (admin==null){
            req.setAttribute("message","登录失败,请重新登录");
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("admin",admin);
            int num=(int)this.getServletContext().getAttribute("num");
            this.getServletContext().setAttribute("num",num+1);
            resp.sendRedirect("manager/index.jsp");
        }
    }
}
