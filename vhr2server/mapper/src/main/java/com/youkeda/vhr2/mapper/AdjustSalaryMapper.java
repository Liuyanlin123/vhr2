package com.youkeda.vhr2.mapper;

import com.youkeda.vhr2.model.AdjustSalary;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);

}
