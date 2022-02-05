package com.hongxing.goods_system.controller;

import com.hongxing.entity.Goods;
import com.hongxing.exception.GoodsCRUDException;
import com.hongxing.goods_system.model.ResultData;
import com.hongxing.goods_system.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/goods/")
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("getList")
    public String getGoodsList(){
        try {
            return new ResultData(goodsService.selectGoodsList()).toJSONString();
        } catch (GoodsCRUDException e) {
            log.error(e.getMessage());
            return new ResultData(e.getMessage(),null).toJSONString();
        }
    }

    @RequestMapping("getByBarcode")
    public String getByBarcode(@RequestParam("barcode") String code){
        try {
            return new ResultData(goodsService.getByBarcode(code)).toJSONString();
        } catch (GoodsCRUDException e) {
            log.error(e.getMessage());
            return new ResultData(e.getMessage(),null).toJSONString();
        }
    }

    @RequestMapping(value = "addGoods",method = RequestMethod.POST)
    public String addGoods(@RequestParam("goods") Goods goods){
        try {
            goodsService.addGoods(goods);
            log.info("新增商品 "+goods);
            return new ResultData("添加成功",null).toJSONString();
        } catch (GoodsCRUDException e) {
            log.error(e.getMessage());
            return new ResultData(e.getMessage(),null).toJSONString();
        }
    }

    @RequestMapping(value = "updateGoods",method = RequestMethod.POST)
    public String updateGoods(@RequestParam("goods") Goods goods){
        try {
            goodsService.updateGoods(goods);
            return new ResultData("更新成功",null).toJSONString();
        } catch (GoodsCRUDException e) {
            log.error(e.getMessage());
            return new ResultData(e.getMessage(),null).toJSONString();
        }
    }
}
