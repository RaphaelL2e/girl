package com.leeyf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:leeyf
 * @date:Created in20:45 2018/9/29
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    /**
     * 通过年龄来查询
     */
    public List<Girl> findByAge(Integer age);
}
