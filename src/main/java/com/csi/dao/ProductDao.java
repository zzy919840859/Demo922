package com.csi.dao;

import com.csi.domain.Page;
import com.csi.domain.Product;

import java.util.List;

public interface ProductDao {

    List<Product> selectAll();
    Page<Product> selectByPage(int pageNum, int pageSize);

    List<Product> findByLikeName(String name);
}
