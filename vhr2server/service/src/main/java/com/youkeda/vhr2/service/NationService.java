package com.youkeda.vhr2.service;


import com.youkeda.vhr2.mapper.NationMapper;
import com.youkeda.vhr2.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
