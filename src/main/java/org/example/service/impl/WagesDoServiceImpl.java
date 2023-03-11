package org.example.service.impl;

import org.example.dao.WagesDoMapper;
import org.example.entity.WagesDo;
import org.example.service.WagesDoService;
import org.example.vo.WagesVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WagesDoServiceImpl implements WagesDoService {
    @Resource
    public WagesDoMapper wagesDoMapper;

    //查询所有
    @Override
    public List<WagesDo> findAll(WagesVo wagesVo) {
        return wagesDoMapper.findAll(wagesVo);
    }

    @Override
    public Integer updateWages(WagesDo wagesDo) {
        return wagesDoMapper.updateWages(wagesDo);
    }

}
