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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/students")
    public ResultData<List<StudentBo>> getAll() {

        List<StudentBo> studentBos = studentService.getAll();
        return ResultData.success(studentBos);
    }


    @PutMapping("/students/{id}")
    public ResultData<StudentBo> updateOne(@PathVariable Long id, @RequestBody StudentRequest request) {
        log.info("updateOne request: {}", request);

        StudentBo studentBo = new StudentBo();
        BeanUtils.copyProperties(request,studentBo);

        log.info("Converted Student bo:{}", studentBo);

        Boolean isSuccess = studentService.updateOne(id,studentBo);

        return ResultData.success(isSuccess);
    }

    @DeleteMapping("/students/{id}")
    public ResultData<Boolean> deleteOne(@PathVariable Long id) {
        log.info("deleteOne request: {}", id);

        Boolean isSuccess = studentService.deleteOne(id);

        return ResultData.success(isSuccess);
    }

    @GetMapping("/students/query")
    public ResultData<List<StudentBo>> queryByName(@RequestParam String name) {
        log.info("queryByName request: {}", name);

        List<StudentBo> studentBos = studentService.queryByName(name);

        return ResultData.success(studentBos);
    }
}

