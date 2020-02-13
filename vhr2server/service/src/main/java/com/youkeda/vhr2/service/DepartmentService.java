package com.youkeda.vhr2.service;

import com.youkeda.vhr2.mapper.DepartmentMapper;
import com.youkeda.vhr2.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments(){
        return departmentMapper.getAllDepartments();
    }

    public void addDepartment(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDepartment(dep);
    }

    public void deleteDepartmentById(Department dep) {
        departmentMapper.deleteDepartmentById(dep);
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }

}
