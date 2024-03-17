package org.fish.code.webdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Toy {
    //唯一标识
    private Long id;
    //数量
    private Integer num;

    // 名称
    private String name;

    private String description;
}
