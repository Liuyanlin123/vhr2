package com.youkeda.vhr2.service;

import com.youkeda.vhr2.mapper.EmployeeMapper;

import com.youkeda.vhr2.model.Employee;
import com.youkeda.vhr2.model.ResponsePageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;

    public final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public ResponsePageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee,beginDateScope);
        Long total = employeeMapper.getTotal(employee,beginDateScope);
        ResponsePageBean bean = new ResponsePageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        //
        double month = (Double.parseDouble(yearFormat.format(endContract))
                - Double.parseDouble(yearFormat.format(beginContract))) * 12
                + (Double.parseDouble(monthFormat.format(endContract))
                - Double.parseDouble(monthFormat.format(beginContract)));

        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));

        int result = employeeMapper.insertSelective(employee);
        if (result == 1) {
            Employee emp = employeeMapper.getEmployeeById(employee.getId());
            logger.info(emp.toString());
            rabbitTemplate.convertAndSend("javaboy.mail.welcome", emp);
        }
        return result;
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }

    public ResponsePageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> list = employeeMapper.getEmployeeByPageWithSalary(page, size);
        ResponsePageBean respPageBean = new ResponsePageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(employeeMapper.getTotal(null, null));
        return respPageBean;
    }

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return employeeMapper.updateEmployeeSalaryById(eid,sid);
    }
}
