package com.example.pms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDTO {
    private Integer id;
    private String name;
    private String address;
    private String code;
}
