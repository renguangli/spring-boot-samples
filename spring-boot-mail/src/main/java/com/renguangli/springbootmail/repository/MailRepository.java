package com.renguangli.springbootmail.repository;

import com.renguangli.springbootmail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * MailRepository
 *
 * @author renguangli 2018/9/3 13:03
 * @since JDK 1.8
 */
@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {

    @Transactional
    void deleteByIdIn(Integer[] ids);

}
