package com.example.pms.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO {
    private Integer id;
    private String name;
    private String description;
    private Date addedDate;
}
