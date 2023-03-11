package org.example.dao;

import org.example.entity.WareDo;
import org.example.vo.WareVo;

import java.util.List;

public interface WareDoMapper {
    //查询所有及条件查询
    List<WareDo> findAll(WareVo wareVo);
    //通过ID删除商品信息
    Integer delWareById(Integer id);
    //通过ID更改商品信息
    Integer updateWare(WareDo wareDo);
}
