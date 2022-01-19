package com.hongxing.goods_system.service.impl;

import com.hongxing.goods_system.bean.Goods;
import com.hongxing.goods_system.mapper.GoodsMapper;
import com.hongxing.goods_system.service.GoodsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private final GoodsMapper goodsMapper;

    public GoodsServiceImpl(GoodsMapper goodsMapper) { this.goodsMapper = goodsMapper; }

    @Override
    @Cacheable(value = "goodsList")
    public List<Goods> selectGoodsList() {
        return goodsMapper.selectGoodsList();
    }

    @Override
    @Cacheable(value = "goods",key = "#p0")
    public Goods getOne(Integer id){
        return goodsMapper.selectGoods(id);
    }
}
