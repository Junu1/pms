package com.example.pms.service.impl;

import com.example.pms.dto.DepartmentDTO;
import com.example.pms.model.Department;
import com.example.pms.repository.DepartmentRepository;
import com.example.pms.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DepartmentServoceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public boolean saveDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setAddress(departmentDTO.getAddress());
        department.setCode(departmentDTO.getCode());
        departmentRepository.save(department);
        return true;

    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department : departments) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setName((department.getName()));
            departmentDTO.setAddress(department.getAddress());
            departmentDTO.setCode(department.getCode());
            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentRepository.getById(departmentDTO.getId());
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setAddress(departmentDTO.getAddress());
        department.setCode(departmentDTO.getCode());
        departmentRepository.save(department);
        return departmentDTO;
    }
}
