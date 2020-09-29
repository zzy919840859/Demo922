package com.csi.service.impl;

import com.csi.dao.AdminDao;
import com.csi.dao.impl.AdminDaoImpl;
import com.csi.domain.Admin;
import com.csi.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(String account, String password) {
        return adminDao.selectByNameAndPassword(account, password);
    }
}
