package com.csi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.domain.Product;
import com.csi.service.ProductService;
import com.csi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "QueryServlet",urlPatterns = "/query")

public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
//        System.out.println("进入get请求");
//        PrintWriter out = resp.getWriter();
//        out.write("getdao了请求");
//        out.flush();
        ProductService ps = new ProductServiceImpl();
        List<Product> products = ps.list();
//        System.out.println(products);
        String s = JSON.toJSONString(products, SerializerFeature.PrettyFormat);
        System.out.println(s);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        System.out.println("account"+account);
        System.out.println("password"+password);
        PrintWriter out = resp.getWriter();
        out.write("postdao了请求");
        out.flush();


    }

}
