package com.hongxing.goods_system.service;

import com.hongxing.entity.Goods;
import com.hongxing.exception.GoodsCRUDException;

import java.util.List;

public interface GoodsService {
    List<Goods> selectGoodsList() throws GoodsCRUDException;
    Goods getByBarcode(String barcode) throws GoodsCRUDException;

    void addGoods(Goods goods) throws GoodsCRUDException;
    void delGoods(Goods goods) throws GoodsCRUDException;
    void updateGoods(Goods goods) throws GoodsCRUDException;
}
