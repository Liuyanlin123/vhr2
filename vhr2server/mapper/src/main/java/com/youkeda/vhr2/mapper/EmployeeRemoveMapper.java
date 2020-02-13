package com.youkeda.vhr2.mapper;

import com.youkeda.vhr2.model.EmployeeRemove;

public interface EmployeeRemoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRemove record);

    int insertSelective(EmployeeRemove record);

    EmployeeRemove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeRemove record);

    int updateByPrimaryKey(EmployeeRemove record);
}
