package com.renguangli.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

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


}
