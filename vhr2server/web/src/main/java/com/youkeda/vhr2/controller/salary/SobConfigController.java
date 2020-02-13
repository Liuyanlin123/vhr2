package com.youkeda.vhr2.controller.salary;

import com.youkeda.vhr2.model.ResponseBean;
import com.youkeda.vhr2.model.ResponsePageBean;
import com.youkeda.vhr2.model.Salary;
import com.youkeda.vhr2.service.EmployeeService;
import com.youkeda.vhr2.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public ResponsePageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PutMapping("/")
    public ResponseBean updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if (result == 1 || result == 2) {
            return ResponseBean.ok("更新成功");
        }
        return ResponseBean.error("更新失败");
    }
}
