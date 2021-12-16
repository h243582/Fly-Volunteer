package com.heyufei.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.user.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{
    /**
     * 根据手机号查询用户
     */
    public User findByMobile(String mobile);

    /**
     * 注册
     */
    @Modifying
    @Query(value = "insert into tb_user(mobile, password, nickname, avatar, is_vip, register_date, update_date, last_date) VALUE (?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
    public void addUser(User user);



}
