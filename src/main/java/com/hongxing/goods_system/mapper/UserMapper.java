package com.hongxing.goods_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongxing.entity.UserBaseInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserBaseInfo> {
    UserBaseInfo selectById(Integer id);
}
