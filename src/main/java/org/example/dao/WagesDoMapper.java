package org.example.dao;

import org.example.entity.WagesDo;
import org.example.vo.WagesVo;

import java.util.List;

public interface WagesDoMapper {
    //查询所有及条件查询
    List<WagesDo> findAll(WagesVo wagesVo);

    Integer updateWages(WagesDo wagesDo);

}