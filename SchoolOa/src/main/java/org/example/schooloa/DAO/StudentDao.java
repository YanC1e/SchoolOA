package org.example.schooloa.DAO;

import org.example.schooloa.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentDao {

    @Select("SELECT * FROM student")
    List<Student> getAllStudents();

    @Insert("INSERT INTO student(name, major, college) VALUES(#{name}, #{major}, #{college})")
    void addStudent(Student student);

    @Update("UPDATE student SET name=#{name}, major=#{major}, college=#{college} WHERE id=#{id}")
    void updateStudent(Student student);

    @Delete("DELETE FROM student WHERE id=#{id}")
    void deleteStudent(Long id);

    @Select("SELECT COUNT(*) FROM student WHERE major=#{majorId}")
    int countByMajorId(Long majorId);
}
