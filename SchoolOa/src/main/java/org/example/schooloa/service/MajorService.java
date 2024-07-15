package org.example.schooloa.service;

import org.example.schooloa.DAO.MajorDao;
import org.example.schooloa.DAO.StudentDao;
import org.example.schooloa.entity.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private StudentDao studentDao;

    public List<Major> getAllMajors() {
        return majorDao.getAllMajors();
    }

    public void addMajor(Major major) {
        majorDao.addMajor(major);
    }

    public void updateMajor(Major major) {
        majorDao.updateMajor(major);
    }

    public String deleteMajor(Long id) {
        if (studentDao.countByMajorId(id) > 0) {
            return "该专业下有学生，不能删除";
        }
        majorDao.deleteMajor(id);
        return "专业删除成功";
    }
}
