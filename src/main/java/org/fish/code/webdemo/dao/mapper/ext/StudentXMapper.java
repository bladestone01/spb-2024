/*
 * create by mybatis-plus-generator  https://github.com/xiweile
 */
package org.fish.code.webdemo.dao.mapper.ext;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fish.code.webdemo.dao.model.Student;

import java.util.List;

/**
 * <p>
 *       自定义mapper接口
 *
 * </p>
 *
 * @author bladestone
 * @since 2024-03-17
 */
@Mapper
public interface StudentXMapper extends BaseMapper<Student> {

    /**
     * 根据名字查询学生(支持模糊查询)
     *
     * @param name
     * @return
     */
    public List<Student> getByName(@Param("name") String  name);

}
