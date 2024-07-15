package org.example.schooloa.DAO;

import org.example.schooloa.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseDao {

    @Select("SELECT * FROM course")
    List<Course> getAllCourses();

    @Insert("INSERT INTO course(name, college) VALUES(#{name}, #{college})")
    void addCourse(Course course);

    @Update("UPDATE course SET name=#{name}, college=#{college} WHERE id=#{id}")
    void updateCourse(Course course);

    @Delete("DELETE FROM course WHERE id=#{id}")
    void deleteCourse(Long id);

    @Select("SELECT COUNT(*) FROM course WHERE college=#{collegeId}")
    int countByCollegeId(Long collegeId);
}
