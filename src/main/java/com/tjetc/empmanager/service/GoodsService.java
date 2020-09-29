package com.tjetc.empmanager.service;

import com.tjetc.empmanager.domain.Goods;

import java.util.List;

public interface GoodsService {
    String addGoods(Goods s);
    List<Goods> findAll();
}
