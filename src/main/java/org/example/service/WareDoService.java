package org.example.service;

import org.example.entity.WareDo;
import org.example.vo.WareVo;

import java.util.List;

public interface WareDoService {
    List<WareDo> findAll(WareVo wareVo);

    Integer delWareById(Integer id);

    Integer updateWare(WareDo wareDo);
//
//    Integer addWare(WareDo wareDo);
}
