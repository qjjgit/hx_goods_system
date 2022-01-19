package com.hongxing.goods_system.controller;

import com.hongxing.goods_system.bean.Goods;
import com.hongxing.goods_system.bean.ResultData;
import com.hongxing.goods_system.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/getGoodsList")
    public String getGoodsList(){
        List<Goods> list = goodsService.selectGoodsList();
        return new ResultData(list).toJSONString();
    }

    @RequestMapping("/test")
    public String test(){
        Goods goods = goodsService.getOne(5);
        return new ResultData(goods).toJSONString();
    }
}
