package org.example.schooloa.DAO;

import org.example.schooloa.entity.Major;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MajorDao {

    @Select("SELECT * FROM major")
    List<Major> getAllMajors();

    @Insert("INSERT INTO major(name, college) VALUES(#{name}, #{college})")
    void addMajor(Major major);

    @Update("UPDATE major SET name=#{name}, college=#{college} WHERE id=#{id}")
    void updateMajor(Major major);

    @Delete("DELETE FROM major WHERE id=#{id}")
    void deleteMajor(Long id);

    @Select("SELECT COUNT(*) FROM major WHERE college=#{collegeId}")
    int countByCollegeId(Long collegeId);
}
