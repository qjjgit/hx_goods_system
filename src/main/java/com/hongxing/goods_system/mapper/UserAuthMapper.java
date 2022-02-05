package com.hongxing.goods_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongxing.entity.UserAuthDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthMapper extends BaseMapper<UserAuthDO> {
    UserAuthDO loginAuth(Integer identityType, String identifier);
}
