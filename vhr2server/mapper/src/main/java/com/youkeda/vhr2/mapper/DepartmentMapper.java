package com.youkeda.vhr2.mapper;

import com.youkeda.vhr2.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDepartment(Department dep);

    void deleteDepartmentById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();

    List<Department> getAllDepartments();
}
