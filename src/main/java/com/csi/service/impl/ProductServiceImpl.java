package com.csi.service.impl;

import com.csi.dao.ProductDao;
import com.csi.dao.impl.ProductDaoImpl;
import com.csi.domain.Page;
import com.csi.domain.Product;
import com.csi.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> list(){
        return productDao.selectAll();
    }

    @Override
    public Page<Product> findByPage(int pageNum, int pageSize) {
        return productDao.selectByPage(pageNum, pageSize);
    }

    @Override
    public List<Product> findByLikeName(String name) {
        return productDao.findByLikeName(name);
    }


}
