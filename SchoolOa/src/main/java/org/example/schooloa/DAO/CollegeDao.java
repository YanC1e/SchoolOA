package org.example.schooloa.DAO;

import org.example.schooloa.entity.College;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollegeDao {

    @Select("SELECT * FROM college")
    List<College> getAllColleges();

    @Insert("INSERT INTO college(name) VALUES(#{name})")
    void addCollege(College college);

    @Update("UPDATE college SET name=#{name} WHERE id=#{id}")
    void updateCollege(College college);

    @Delete("DELETE FROM college WHERE id=#{id}")
    void deleteCollege(Long id);
}
