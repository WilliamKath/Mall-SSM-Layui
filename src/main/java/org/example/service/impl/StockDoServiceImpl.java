package org.example.service.impl;

import org.example.dao.StockDoMapper;
import org.example.entity.StockDo;
import org.example.service.StockDoService;
import org.example.vo.StockVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockDoServiceImpl implements StockDoService {
    @Resource
    public StockDoMapper stockDoMapper;

    //查询所有及条件查询
    @Override
    public List<StockDo> findAll(StockVo stockVo) {
        return stockDoMapper.findAll(stockVo);
    }

    //通过ID删除员工信息
    @Override
    public Integer delStockById(Integer id) {
        Integer code = 0 ;
        if (stockDoMapper.delStockById(id) != null && stockDoMapper.delWareById(id) != null && stockDoMapper.delWareSrcById(id) != null){
            code = 1;
        } else {
            code = 0;
        }
        return code;
    }

    //修改员工信息
    @Override
    public Integer updateStock(StockDo stockDo) {
        return stockDoMapper.updateStock(stockDo);
    }

    //添加员工信息
    @Override
    public Integer addStock(StockDo stockDo) {
        Integer code = 0 ;
        if (stockDoMapper.addStock(stockDo) != null && stockDoMapper.addWareSrc(stockDo) != null && stockDoMapper.addWare(stockDo) != null){
            code = 1;
        } else {
            code = 0;
        }
        return code;
    }

}
