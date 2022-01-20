package com.hongxing.goods_system.bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
    /**
     * 
     */
    private Integer uid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Integer role;

    /**
     * 
     */
    private String mark;

    private static final long serialVersionUID = 1L;
}