package com.csi.dao.impl;

import com.csi.dao.GoodsDao;
import com.csi.domain.Goods;
import com.csi.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public int insert(Goods g) {
        Connection conn= DBUtil.getConnection();
        PreparedStatement pstmt=DBUtil.getPstmt(conn,"insert into goods(name,image,price) values(?,?,?)",g.getName(),g.getImage(),g.getPrice());
        int i=DBUtil.update(pstmt);
        DBUtil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public List<Goods> selectAll() {
        Connection conn= DBUtil.getConnection();
        PreparedStatement pstmt=DBUtil.getPstmt(conn,"select * from goods");
        ResultSet rs=DBUtil.query(pstmt);
        List<Goods> list=new ArrayList<Goods>();
        try {
            while (rs.next()){
                list.add(new Goods(rs.getInt("id"),
                            rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price")));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
