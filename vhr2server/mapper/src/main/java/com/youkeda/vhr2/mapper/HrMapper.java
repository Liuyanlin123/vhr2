package com.youkeda.vhr2.mapper;

import com.youkeda.vhr2.model.Hr;
import com.youkeda.vhr2.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(Integer id, String keywords);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);
}