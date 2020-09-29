package com.csi.service;

import com.csi.domain.Page;
import com.csi.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();
    Page<Product> findByPage(int pageNum, int pageSize);
    public List<Product> findByLikeName(String name);
}
