package com.csi.dao;

import com.csi.domain.Admin;

public interface AdminDao {
    Admin selectByNameAndPassword(String account, String password);
}
