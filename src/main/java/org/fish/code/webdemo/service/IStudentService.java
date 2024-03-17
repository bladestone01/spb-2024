package org.fish.code.webdemo.service;

import org.fish.code.webdemo.domain.StudentBo;

import java.util.List;

public interface IStudentService {

    public Long createStudent(StudentBo studentBo);

    /**
     * 查询所有的学生记录.
     *
     * @return
     */
    public List<StudentBo> getAll();

    public Boolean updateOne(Long id, StudentBo studentBo);

    public Boolean deleteOne(Long id);


    /**
     * 根据名字查询学生(支持模糊查询)
     * @param name
     * @return
     */
    public List<StudentBo> queryByName(String name);
}
