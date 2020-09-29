package com.csi.controller;

import com.csi.domain.Product;
import com.csi.service.ProductService;
import com.csi.service.impl.ProductServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "ProductServlet",urlPatterns = "/product")

public class ProductServlet extends HttpServlet {

    private ProductService ps;

    public ProductServlet() {
        this.ps = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        //获取op
        String op = req.getParameter("op");
        //判断
        if ("like".equals(op)) {
            this.like(req, resp);
        }
//        else if ("findAll".equals(op)){
//            this.findAll(req, resp);
//        }

    }

//    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        List<Product> list = this.ps.list();
//        System.out.println(list);
//        PrintWriter out = resp.getWriter();
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(list);
//        out.write(jsonString);
//        out.flush();
//    }

    private void like(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        List<Product> list = this.ps.findByLikeName(name);
        System.out.println(list);
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        out.write(jsonString);
        out.flush();
    }


}
