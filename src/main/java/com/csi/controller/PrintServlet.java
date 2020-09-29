package com.csi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
@WebServlet(name = "PrintServlet",urlPatterns = "/print")

public class PrintServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //输出
        PrintWriter out =resp.getWriter();
        out.println(LocalDateTime.now()+"后台传递的时间");
        out.flush();
        out.close();
        while (true){
            System.out.println("打印中");
        }
    }
}
