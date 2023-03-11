package org.example.service;

import org.example.entity.WagesDo;
import org.example.vo.WagesVo;

import java.util.List;

public interface WagesDoService {
    //查找方法
    List<WagesDo> findAll(WagesVo wagesVo);

    Integer updateWages(WagesDo wagesDo);

}
