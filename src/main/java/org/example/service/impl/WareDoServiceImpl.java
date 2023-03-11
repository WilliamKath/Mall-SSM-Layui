package org.example.service.impl;

import org.example.dao.WareDoMapper;
import org.example.entity.WareDo;
import org.example.service.WareDoService;
import org.example.vo.WareVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WareDoServiceImpl implements WareDoService {
    @Resource
    public WareDoMapper WareDoMapper;

    //查询所有及条件查询
    @Override
    public List<WareDo> findAll(WareVo wareVo) {
        return WareDoMapper.findAll(wareVo);
    }

    //通过ID删除员工信息
    @Override
    public Integer delWareById(Integer id) {
        return WareDoMapper.delWareById(id);
    }

    //修改员工信息
    @Override
    public Integer updateWare(WareDo wareDo) {
        return WareDoMapper.updateWare(wareDo);
    }

}
