/*
 * create by mybatis-plus-generator  https://github.com/xiweile
 */
package org.fish.code.webdemo.controller;


import lombok.extern.slf4j.Slf4j;
import org.fish.code.webdemo.domain.ResultData;
import org.fish.code.webdemo.domain.StudentBo;
import org.fish.code.webdemo.domain.request.StudentRequest;
import org.fish.code.webdemo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bladestone
 * @since 2024-03-17
 */
@RestController
@RequestMapping("/apis")
@Slf4j
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/students")
    public ResultData<StudentBo> createOne(@RequestBody  StudentRequest request) {
        log.info("createStudent request: {}", request);

        StudentBo studentBo = new StudentBo();
        BeanUtils.copyProperties(request,studentBo);

        log.info("Converted Student bo:{}", studentBo);

        Long id =  studentService.createStudent(studentBo);

        return ResultData.success(id);
    }
}

