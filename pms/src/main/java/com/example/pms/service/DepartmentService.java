package com.example.pms.service;

import com.example.pms.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    boolean saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);
}
