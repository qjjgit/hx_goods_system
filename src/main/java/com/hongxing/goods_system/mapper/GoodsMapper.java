package com.hongxing.goods_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongxing.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsMapper extends BaseMapper<Goods> {

    Goods selectGoods(Integer id);

    List<Goods> selectGoodsList();

    int addGoods(@Param(value = "goods") Goods goods);

    /**
     * 假删除 set: flag = 1
     * @param goodsId 商品id
     * @return 返回 被删除的商品的名称
     */
    int delGoods(@Param(value = "gid") Integer goodsId);


    int updateGoods(@Param(value = "goods") Goods goods);

    Goods selectByBarcode(String barcode);
}
