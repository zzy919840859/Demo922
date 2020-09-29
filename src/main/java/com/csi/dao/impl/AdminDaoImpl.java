package com.csi.dao.impl;

import com.csi.dao.AdminDao;
import com.csi.domain.Admin;
import com.csi.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin selectByNameAndPassword(String account, String password) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement psmt = DBUtil.getPstmt(conn,"select * from admin where account=? and password=?",account,password);
        ResultSet rs = DBUtil.query(psmt);
        try {
            if (rs.next()){
                return new Admin(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.close(conn,psmt,rs);
        }
    }
}
