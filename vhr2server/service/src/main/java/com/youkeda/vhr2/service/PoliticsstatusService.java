package com.youkeda.vhr2.service;

import com.youkeda.vhr2.mapper.PoliticsStatusMapper;

import com.youkeda.vhr2.model.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsStatusMapper politicsstatusMapper;

    public List<PoliticsStatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
