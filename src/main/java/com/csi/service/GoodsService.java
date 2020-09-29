package com.csi.service;

import com.csi.domain.Goods;

import java.util.List;

public interface GoodsService {
    String addGoods(Goods g);
    List<Goods> findAll();
}
