package com.csi.listener;

import com.csi.util.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitCountListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("服务器启动");
        Connection conn = DBUtil.getConnection();
        PreparedStatement psmt = DBUtil.getPstmt(conn,"select count(1) from  count");
        ResultSet rs = DBUtil.query(psmt);
        int num=0;
        try {
            if (rs.next()){
                num=rs.getInt(1);
            }
            ServletContext sc= servletContextEvent.getServletContext();
            sc.setAttribute("num",num);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,psmt,rs);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("服务器被关闭");
        Connection conn = DBUtil.getConnection();
        String sql = "update count set num=?";
        PreparedStatement psmt = DBUtil.getPstmt(conn,sql,
                (int)servletContextEvent.getServletContext().getAttribute("num"));
        DBUtil.update(psmt);
    }
}
