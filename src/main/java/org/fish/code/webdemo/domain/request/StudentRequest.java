package org.fish.code.webdemo.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private Long id;
    private String name;
    private String major;
    private String school;
    private Integer age;
}
