package com.csi.dao.impl;

import com.csi.dao.ProductDao;
import com.csi.domain.Page;
import com.csi.domain.Product;
import com.csi.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> selectAll(){
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from easybuy_product");
        ResultSet rs = DBUtil.query(pstmt);
        List<Product> products = new ArrayList<>();
        try {
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setStock(rs.getInt(5));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return products;
    }

    private int count(){
        Connection conn =  DBUtil.getConnection();
        String sql = "select count(1) from easybuy_product";
        PreparedStatement psmt = DBUtil.getPstmt(conn,sql);
        ResultSet rs = DBUtil.query(psmt);
        try {
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Page<Product> selectByPage(int pageNum, int pageSize) {
        Page<Product> page = new Page<>(pageNum,pageSize);
        page.setTotalData(this.count());
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        String sql = "select * from easybuy_product limit ?,?";
        PreparedStatement psmt = DBUtil.getPstmt(conn,sql,page.start(),page.getPageSize());
        ResultSet rs = DBUtil.query(psmt);
        List<Product> products = new ArrayList<>();
        try {
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setStock(rs.getInt(5));
                products.add(product);
            }
            page.setData(products);
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        DBUtil.close(conn, psmt, null);
        return null;
    }

    @Override
    public List<Product> findByLikeName(String name){
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        String sql = "select * from easybuy_product where name like ?";
        PreparedStatement psmt = DBUtil.getPstmt(conn,sql,"%"+name+"%");
        ResultSet rs = DBUtil.query(psmt);
        List<Product> products = new ArrayList<>();
        try {
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setStock(rs.getInt(5));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        DBUtil.close(conn, psmt, null);
        return products;
    }

}
