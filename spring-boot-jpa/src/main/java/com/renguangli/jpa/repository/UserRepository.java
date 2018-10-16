package com.renguangli.jpa.repository;

import com.renguangli.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    Page<User> findAll(Specification<User> spec, Pageable pageable);

    @Transactional
    void deleteByUserIdIn(Long[] userIds);

    @Transactional
    @Modifying
    @Query("update User set password = ?1 where username=?2")
    void updateUser(String password, String username);

}
