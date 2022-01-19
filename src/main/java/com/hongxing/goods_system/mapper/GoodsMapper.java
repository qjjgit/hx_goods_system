package com.hongxing.goods_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongxing.goods_system.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
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
     * @param gid 商品id
     * @return 返回 被删除的商品的名称
     */
    int delGoods(Integer gid);


    int updateGoods(@Param(value = "goods") Goods goods);
}
