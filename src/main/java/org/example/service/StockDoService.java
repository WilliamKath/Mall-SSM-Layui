package org.example.service;

import org.example.entity.StockDo;
import org.example.vo.StockVo;

import java.util.List;

public interface StockDoService {
    List<StockDo> findAll(StockVo stockVo);

    Integer delStockById(Integer id);

    Integer updateStock(StockDo stockDo);

    Integer addStock(StockDo stockDo);


}
