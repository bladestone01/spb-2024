package org.fish.code.webdemo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fish.code.webdemo.dao.model.Student;
import org.fish.code.webdemo.dao.repo.StudentDao;
import org.fish.code.webdemo.domain.StudentBo;
import org.fish.code.webdemo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Long createStudent(StudentBo studentBo) {
        log.info("StudentServiceImpl.createStudent:{}", studentBo);

        Student student = new Student();
        BeanUtils.copyProperties(studentBo, student);

        this.studentDao.save(student);
        log.info("Student New Id:{}", student.getId());

        return student.getId();
    }
}
