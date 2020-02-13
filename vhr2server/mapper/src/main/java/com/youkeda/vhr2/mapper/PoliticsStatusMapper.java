package com.youkeda.vhr2.mapper;


import com.youkeda.vhr2.model.PoliticsStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliticsStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoliticsStatus record);

    int insertSelective(PoliticsStatus record);

    PoliticsStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoliticsStatus record);

    int updateByPrimaryKey(PoliticsStatus record);

    List<PoliticsStatus> getAllPoliticsstatus();
}