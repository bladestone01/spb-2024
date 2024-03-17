/*
 * create by mybatis-plus-generator  https://github.com/xiweile
 */
package org.fish.code.webdemo.dao.repo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fish.code.webdemo.dao.mapper.ext.StudentXMapper;
import org.fish.code.webdemo.dao.model.Student;
import org.fish.code.webdemo.dao.mapper.StudentMapper;
import org.fish.code.webdemo.dao.repo.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bladestone
 * @since 2024-03-17
 */
@Service
public class StudentDaoImpl extends ServiceImpl<StudentMapper, Student> implements StudentDao {
    @Autowired
    private StudentXMapper studentXMapper;


    public StudentXMapper getStudentXMapper() {
        return studentXMapper;
    }
}
