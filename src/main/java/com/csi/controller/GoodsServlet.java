package com.csi.controller;

import com.csi.domain.Goods;
import com.csi.domain.Page;
import com.csi.service.GoodsService;
import com.csi.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "goodsServlet",urlPatterns = "/goods")
@MultipartConfig
public class GoodsServlet extends HttpServlet {
    GoodsService gs=new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        if("add".equals(op)){
            this.add(req,resp);
        }else if("findAll".equals(op)){
            this.findAll(req,resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> all=gs.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("showAllGoods.jsp").forward(req,resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name=req.getParameter("name");
        String price=req.getParameter("price");
        //获取图片
        Part part=req.getPart("img");
        //获取提交图片名称
        String oldName=part.getSubmittedFileName();
        //给图片起一个新名称
        String newName="/"+
        UUID.randomUUID().toString().replaceAll("-","").toUpperCase()
                +oldName.substring(oldName.lastIndexOf("."));
        //找到文件储存位置
        String path=this.getServletContext().getRealPath("/upload");
        //创建一个文件对象
        File f=new File(path);
        //判断
        if(!f.exists()){
            f.mkdir();
        }
        //part接口进行上传
        part.write(path+newName);
        String s=gs.addGoods(new Goods(1,name,"/upload"+newName,Double.valueOf(price)));
        System.out.println("s");
        resp.sendRedirect("addGoods.jsp");

    }
}
