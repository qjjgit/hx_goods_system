package com.hongxing.goods_system.bean;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private String barcode;
    private String unit;
    private Float price;
    private Float orig;

    public Goods() {
    }

    public Goods(String name, String barcode, String unit, Float price, Float orig) {
        this.name = name;
        this.barcode = barcode;
        this.unit = unit;
        this.price = price;
        this.orig = orig;
    }

    public Goods(Integer id, String name, String barcode, String unit, Float price, Float orig) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.unit = unit;
        this.price = price;
        this.orig = orig;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", orig=" + orig +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this==obj)return true;
        if (obj==null)return false;
        if (getClass()!=obj.getClass())return false;
        Goods o = (Goods) obj;
        if (!name.equals(o.getName()))return false;
        if (!barcode.equals(o.getBarcode()))return false;
        if (!unit.equals(o.getUnit()))return false;
        if (!price.equals(o.getPrice()))return false;
        return orig.equals(o.getOrig());
    }

}
