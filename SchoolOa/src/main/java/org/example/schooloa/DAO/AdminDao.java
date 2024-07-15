package org.example.schooloa.DAO;

import org.example.schooloa.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao {

    @Select("SELECT * FROM admin WHERE username = #{username}")
    Admin findByUsername(String username);
}
