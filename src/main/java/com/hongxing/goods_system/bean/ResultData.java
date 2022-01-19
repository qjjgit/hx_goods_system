package com.hongxing.goods_system.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class ResultData {
    public Integer code = 200;
    public String msg = "";
    public Object data;

    public ResultData() { }

    public ResultData(Object data) {
        this.data = data;
    }

    public ResultData(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public String toJSONString(){
        return JSON.toJSONString(this);
    }
}
