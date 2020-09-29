package com.csi.dao;

import com.csi.domain.Goods;

import java.util.List;

public interface GoodsDao {
    int insert(Goods g);
    List<Goods> selectAll();
}
