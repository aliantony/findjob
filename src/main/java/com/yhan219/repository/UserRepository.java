package com.yhan219.repository;

import com.yhan219.domain.Auth;
import com.yhan219.domain.Role;
import com.yhan219.domain.User;
import com.yhan219.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yhan219 on 2017/2/12.
 */
@Mapper
public interface UserRepository {

    @Select("select * from t_user where username = #{username}")
    User getUserByUsername(@Param("username") String username);

    @Select("select * from t_role r left join t_user_role ur on r.id = ur.role_id where ur.user_id = #{0}")
    List<Role> getRolesByUserId(String id);

    @Select("select * from t_auth a left join t_role_auth r on r.auth_id = a.id where r.id = #{0} ")
    List<Auth> getAuthByRoleId(String id);

    @Select("select * from t_auth a left join t_role_auth ra on ra.auth_id = a.id left join t_user_role ur on ur.role_id = ra.role_id where ur.user_id = #{0} ")
    List<Auth> getAuthsByUserId(String id);

}
