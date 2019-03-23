package com.enter.platform.mapper;

import com.enter.platform.DO.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Liquid
 * @类名： UserMapper
 * @描述：
 * @date 2019/3/23
 */

@CacheNamespace
@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {
    Boolean existsWithOpenid(String userOpenid);

    Integer updateByOpenId(User user);

    String selectUserId(String userOpenid);
}