package org.fish.code.webdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBo {
    Long id;
    private String name;
    private String major;
    private String school;
}
