package com.youkeda.vhr2.mapper;

import com.youkeda.vhr2.model.EmployeeEc;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEcMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeEc record);

    int insertSelective(EmployeeEc record);

    EmployeeEc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeEc record);

    int updateByPrimaryKey(EmployeeEc record);
}
