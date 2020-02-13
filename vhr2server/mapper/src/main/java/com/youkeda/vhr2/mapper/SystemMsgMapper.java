package com.youkeda.vhr2.mapper;


import com.youkeda.vhr2.model.SystemMsg;

public interface SystemMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemMsg record);

    int insertSelective(SystemMsg record);

    SystemMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemMsg record);

    int updateByPrimaryKey(SystemMsg record);
}