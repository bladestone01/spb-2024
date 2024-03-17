package org.fish.code.webdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.fish.code.webdemo.domain.ResultData;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apis")
@Slf4j
public class UserController {

    /**
     * form usage in real application.
     *
     * @param userData
     * @return
     */
    @PostMapping("/users/login")
    public ResultData<Map<String, Object>> login(@RequestParam("username") String username,
                                                 @RequestParam("password") String password) {
        log.info("User Data, username:{}, password:{}", username, password);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("status", 200);
        dataMap.put("message", "ok");

        return ResultData.success(dataMap);
    }
}
