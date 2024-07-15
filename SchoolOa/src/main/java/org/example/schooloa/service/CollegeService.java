package org.example.schooloa.service;

import org.example.schooloa.DAO.CollegeDao;
import org.example.schooloa.DAO.MajorDao;
import org.example.schooloa.DAO.CourseDao;
import org.example.schooloa.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private CourseDao courseDao;

    public List<College> getAllColleges() {
        return collegeDao.getAllColleges();
    }

    public void addCollege(College college) {
        collegeDao.addCollege(college);
    }

    public void updateCollege(College college) {
        collegeDao.updateCollege(college);
    }

    public String deleteCollege(Long id) {
        if (majorDao.countByCollegeId(id) > 0 || courseDao.countByCollegeId(id) > 0) {
            return "该学院下有专业或课程，不能删除";
        }
        collegeDao.deleteCollege(id);
        return "学院删除成功";
    }
}
