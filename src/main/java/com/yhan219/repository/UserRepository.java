package com.yhan219.repository;

import com.yhan219.domain.Role;
import com.yhan219.domain.User;
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

    @Select("select r.id,r.name from t_role r left join t_user_role ur on r.id = ur.role_id where ur.user_id = #{0}")
    List<Role> getRolesByUserId(String id);

}
