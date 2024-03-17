/*
 * create by mybatis-plus-generator  https://github.com/xiweile
 */
package org.fish.code.webdemo.dao.repo;

import org.fish.code.webdemo.dao.mapper.ext.StudentXMapper;
import org.fish.code.webdemo.dao.model.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bladestone
 * @since 2024-03-17
 */
public interface StudentDao extends IService<Student> {

    public StudentXMapper getStudentXMapper();
}
