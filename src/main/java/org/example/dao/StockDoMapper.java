package org.example.dao;

import org.example.entity.StockDo;
import org.example.entity.WareDo;
import org.example.vo.StockVo;

import java.util.List;

public interface StockDoMapper {
    //查询所有及条件查询
    List<StockDo> findAll(StockVo stockVo);
    //通过ID删除信息
    Integer delStockById(Integer id);

    Integer delWareById(Integer id);

    Integer delWareSrcById(Integer id);
    //通过ID更改信息
    Integer updateStock(StockDo stockDo);
    //添加信息
    Integer addStock(StockDo stockDo);

    Integer addWare(StockDo stockDo);

    Integer addWareSrc(StockDo stockDo);
}