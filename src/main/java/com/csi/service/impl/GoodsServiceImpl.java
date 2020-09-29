package com.csi.service.impl;

import com.csi.dao.GoodsDao;
import com.csi.dao.impl.GoodsDaoImpl;
import com.csi.domain.Goods;
import com.csi.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao gd=new GoodsDaoImpl();
    @Override
    public String addGoods(Goods g) {
        return gd.insert(g)>0?"添加成功":"添加失败";
    }

    @Override
    public List<Goods> findAll() {
        return gd.selectAll();
    }
}
