package com.youkeda.vhr2;

import com.google.gson.Gson;
import com.youkeda.vhr2.mapper.*;
import com.youkeda.vhr2.model.Department;
import com.youkeda.vhr2.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan(basePackages = "com.youkeda.vhr2.mapper")
class WebApplicationTests {


    @Autowired
    HrMapper hrMapper;

    @Autowired
    DepartmentService departmentService;


    @Test
    void contextLoads() {
        List<Department> departments = departmentService.getAllDepartments();
        for (Department department : departments) {
            System.out.println(department.getName());
            List<Department> childDepartments = department.getChildren();
            for (Department childDepartment : childDepartments) {
                System.out.print(childDepartment.getName()+" ");
            }
            System.out.println("___________________");
        }
    }

}
