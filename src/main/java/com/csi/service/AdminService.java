package com.csi.service;

import com.csi.domain.Admin;

public interface AdminService {
    Admin login(String account, String password);
}
