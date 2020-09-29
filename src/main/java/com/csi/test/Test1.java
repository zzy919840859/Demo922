package com.csi.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.domain.Product;
import com.csi.service.ProductService;
import com.csi.service.impl.ProductServiceImpl;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        List<Product> products = productService.list();
        String s = JSON.toJSONString(products,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.PrettyFormat);
        System.out.println(s);
    }
}
