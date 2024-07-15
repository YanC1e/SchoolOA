package org.example.schooloa.service;

import org.example.schooloa.entity.Student;
import org.example.schooloa.DAO.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }
}
