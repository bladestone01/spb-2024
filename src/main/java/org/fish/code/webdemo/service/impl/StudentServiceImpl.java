package org.fish.code.webdemo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fish.code.webdemo.dao.model.Student;
import org.fish.code.webdemo.dao.repo.StudentDao;
import org.fish.code.webdemo.domain.StudentBo;
import org.fish.code.webdemo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<StudentBo> getAll() {

        List<Student> students =  this.studentDao.list();

        List<StudentBo> studentBos = new ArrayList<>();
        for (Student student : students) {
           StudentBo studentBo = new StudentBo();
           BeanUtils.copyProperties(student, studentBo);

           studentBos.add(studentBo);
        }

        return studentBos;
    }

    @Override
    public Boolean updateOne(Long id, StudentBo studentBo) {
        log.info("Update one, id:{}, studentBo:{}", id, studentBo);

        Student student = new Student();
        studentBo.setId(id);
        BeanUtils.copyProperties(studentBo, student);

        return this.studentDao.updateById(student);
    }

    @Override
    public Boolean deleteOne(Long id) {
        log.info("Delete one, id:{}", id);

        return this.studentDao.removeById(id);
    }

    @Override
    public List<StudentBo> queryByName(String name) {
        log.info("Query By Name;{}", name);

        List<Student> students = this.studentDao.getStudentXMapper().getByName(name);

        List<StudentBo> studentBos = new ArrayList<>();
        students.forEach(student -> {
            StudentBo studentBo = new StudentBo();
            BeanUtils.copyProperties(student, studentBo);
            studentBos.add(studentBo);
        });

        return studentBos;
    }
}
