package com.hongxing.goods_system.service;

import com.hongxing.goods_system.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> selectGoodsList();
    Goods getOne(Integer id);
}
