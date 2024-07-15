package org.example.schooloa.service;

import org.example.schooloa.DAO.CourseDao;
import org.example.schooloa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    public void deleteCourse(Long id) {
        courseDao.deleteCourse(id);
    }
}
