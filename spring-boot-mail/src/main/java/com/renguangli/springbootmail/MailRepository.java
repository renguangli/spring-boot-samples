package com.renguangli.springbootmail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MailRepository
 *
 * @author renguangli 2018/9/3 13:03
 * @since JDK 1.8
 */
@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {

}
