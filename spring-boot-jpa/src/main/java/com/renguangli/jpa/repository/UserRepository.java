package com.renguangli.jpa.repository;

import com.renguangli.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/*
 *
 * Created by renguangli at 2018/10/15 20:02
 * @since JDK1.8
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query("update User set password = ?1 where username=?2")
    User updateUser(String password, String username);
}
