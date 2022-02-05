package com.hongxing.goods_system.service.impl;

import com.hongxing.entity.Goods;
import com.hongxing.exception.GoodsCRUDException;
import com.hongxing.goods_system.mapper.GoodsMapper;
import com.hongxing.goods_system.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private final GoodsMapper goodsMapper;

    public GoodsServiceImpl(GoodsMapper goodsMapper) { this.goodsMapper = goodsMapper; }

    @Override
//    @Cacheable(value = "goodsList")
    public List<Goods> selectGoodsList() throws GoodsCRUDException {
        List<Goods> list = goodsMapper.selectGoodsList();
        if (list == null || list.isEmpty()){
            throw new GoodsCRUDException("当前商品库为空");
        }
        return list;
    }

    @Override
    public Goods getByBarcode(String barcode) throws GoodsCRUDException {
        Goods goods = goodsMapper.selectByBarcode(barcode);
        if (goods == null){
            throw new GoodsCRUDException("库中没有对应的商品");
        }
        return goods;
    }

    @Override
    public void addGoods(Goods goods) throws GoodsCRUDException {
        int i = goodsMapper.addGoods(goods);
        if (i < 1){
            throw new GoodsCRUDException("添加商品出错了");
        }
    }

    @Override
    public void delGoods(Goods goods) throws GoodsCRUDException {
        int i = goodsMapper.delGoods(goods.getId());
        if (i < 1){
            throw new GoodsCRUDException("删除商品出错了");
        }
    }

    @Override
    public void updateGoods(Goods goods) throws GoodsCRUDException {
        int i = goodsMapper.updateGoods(goods);
        if (i < 1){
            throw new GoodsCRUDException("更新商品出错了");
        }
    }
}
