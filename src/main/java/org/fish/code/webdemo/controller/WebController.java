package org.fish.code.webdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.fish.code.webdemo.domain.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WebController {
    @GetMapping("/hello")
    public ResultData hello() {
        log.info("hello");
        return ResultData.success("hello");
    }
}
