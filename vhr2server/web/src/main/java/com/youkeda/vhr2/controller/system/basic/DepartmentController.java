package com.youkeda.vhr2.controller.system.basic;

import com.youkeda.vhr2.model.Department;
import com.youkeda.vhr2.model.ResponseBean;
import com.youkeda.vhr2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @PostMapping("/")
    public ResponseBean addDep(@RequestBody Department dep) {
        departmentService.addDepartment(dep);
        if (dep.getResult() == 1) {
            return ResponseBean.ok("添加成功", dep);
        }
        return ResponseBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteDepById(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepartmentById(dep);
        if (dep.getResult() == -2) {
            return ResponseBean.error("该部门下有子部门，删除失败");
        } else if (dep.getResult() == -1) {
            return ResponseBean.error("该部门下有员工，删除失败");
        } else if (dep.getResult() == 1) {
            return ResponseBean.ok("删除成功");
        }
        return ResponseBean.error("删除失败");
    }
}