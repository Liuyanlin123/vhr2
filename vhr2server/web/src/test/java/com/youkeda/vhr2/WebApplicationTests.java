package com.youkeda.vhr2;

import com.youkeda.vhr2.mapper.AdjustSalaryMapper;
import com.youkeda.vhr2.mapper.AppraiseMapper;
import com.youkeda.vhr2.mapper.DepartmentMapper;
import com.youkeda.vhr2.mapper.EmployeeEcMapper;
import com.youkeda.vhr2.model.AdjustSalary;
import com.youkeda.vhr2.model.Department;
import com.youkeda.vhr2.model.EmployeeEc;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan(basePackages = "com.youkeda.vhr2.mapper")
class WebApplicationTests {

    @Autowired
    AdjustSalaryMapper adjustSalaryMapper;

    @Autowired
    AppraiseMapper appraiseMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeEcMapper employeeEcMapper;

    @Test
    void contextLoads() {
        EmployeeEc employeeEc = employeeEcMapper.selectByPrimaryKey(1);

    }

}
