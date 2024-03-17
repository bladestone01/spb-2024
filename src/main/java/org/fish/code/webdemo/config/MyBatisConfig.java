package org.fish.code.webdemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.fish.code.webdemo.dao.mapper")
public class MyBatisConfig {
}
