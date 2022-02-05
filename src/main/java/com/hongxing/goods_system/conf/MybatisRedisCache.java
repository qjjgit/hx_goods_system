package com.hongxing.goods_system.conf;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class MybatisRedisCache implements Cache {
    private String id;
    private RedisTemplate<Object,Object> redisTemplate;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private static final long EXPIRE_TIME_IN_MINUTES = 1; // redis过期时间


    public MybatisRedisCache(String id) {
        if(id==null){
            throw new IllegalArgumentException("未获取到缓存实例id");
        }
        this.id = id;
    }

    private RedisTemplate<Object, Object> getRedisTemplate(){
        return ApplicationContextHolder.getBean("redisTemplate");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        // TODO: 2022/1/26 判空 null值加上过期时间
        getRedisTemplate().boundHashOps(getId()).put(key, value);
        log.info("[结果放入到缓存中: " + key + "=" + value+" ]");

    }

    @Override
    public Object getObject(Object key) {
        Object value = getRedisTemplate().boundHashOps(getId()).get(key);
        log.info("[从缓存中获取了: " + key + "=" + value+" ]");
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        Object value = getRedisTemplate().boundHashOps(getId()).delete(key);
        log.info("[从缓存删除了: " + key + "=" + value+" ]");
        return value;
    }

    @Override
    public void clear() {
        getRedisTemplate().delete(getId());
        log.info("清空缓存!!!");
    }

    @Override
    public int getSize() {
        Long size = getRedisTemplate().boundHashOps(getId()).size();
        return size == null ? 0 : size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
