package com.renguangli.jpa;

import com.renguangli.jpa.entity.User;
import com.renguangli.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		long start = System.currentTimeMillis();
		List<User> users = new ArrayList<>(1002);
		for (int i = 0; i < 1000000; i++) {
			User user = new User();
			user.setUsername(UUID.randomUUID().toString().replace("-", "").substring(0,15));
			user.setPassword(UUID.randomUUID().toString().replace("-", "").substring(0,11));
			if (i % 2 == 0) {
				user.setSex('男');
			} else {
				user.setSex('女');
			}
			user.setCreateTime(new Date());
			user.setAge(18);
			users.add(user);
			if (users.size() == 1000) {
				userRepository.save(users);
				users.clear();
			}
		}

		System.out.println(System.currentTimeMillis() - start);
	}

}
