package com.renguangli.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

	@Test
	public void str() {
	    // 操作字符串
        ValueOperations<String, String> strOps = redisTemplate.opsForValue();
        String key = "redisTemplate.set";
        strOps.set(key, "sss");
        strOps.set("a", "a", 1000);
        strOps.set("b", "b", 1000, TimeUnit.MILLISECONDS);
        String s = strOps.get(key);
        strOps.append(key, "c");
        strOps.increment("incr");
        strOps.decrement("desc");
        strOps.setIfAbsent(key, "c");
        System.out.println(s);
    }

    @Test
    public void test() {
        String key = "hash";
        // 操作 Hash
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, "1", "1");
        hashOperations.put(key, "2", "2");
        hashOperations.put(key, "3", "3");
        Map<Object, Object> map = hashOperations.entries(key);
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());

        }

        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
    }

}
