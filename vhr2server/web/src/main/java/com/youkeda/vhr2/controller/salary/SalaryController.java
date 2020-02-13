package com.youkeda.vhr2.controller.salary;

import com.youkeda.vhr2.model.ResponseBean;
import com.youkeda.vhr2.model.Salary;
import com.youkeda.vhr2.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PostMapping("/")
    public ResponseBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.deleteSalaryById(id) == 1) {
            return ResponseBean.ok("删除成功！");
        }
        return ResponseBean.error("删除失败！");
    }

    @PutMapping("/")
    public ResponseBean updateSalaryById(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return ResponseBean.ok("更新成功!");
        }
        return ResponseBean.error("更新失败!");
    }
}