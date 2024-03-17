/*
 * create by mybatis-plus-generator  https://github.com/xiweile
 */
package org.fish.code.webdemo.dao.repo.impl;

import org.fish.code.webdemo.dao.model.Student;
import org.fish.code.webdemo.dao.mapper.StudentMapper;
import org.fish.code.webdemo.dao.repo.StudentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentDao {

}
