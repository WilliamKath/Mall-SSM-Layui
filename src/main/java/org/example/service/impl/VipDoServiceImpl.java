package org.example.service.impl;

import org.example.dao.VipDoMapper;
import org.example.entity.VipDo;
import org.example.service.VipDoService;
import org.example.vo.VipVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VipDoServiceImpl implements VipDoService {
    @Resource
    public VipDoMapper vipDoMapper;

    //查询所有及条件查询
    @Override
    public List<VipDo> findAll(VipVo vipVo) {
        return vipDoMapper.findAll(vipVo);
    }

    //通过ID删除员工信息
    @Override
    public Integer delVipById(Integer id) {
        return vipDoMapper.delVipById(id);
    }
    @Override
    //修改员工信息
    public Integer updateVip(VipDo vipDo) {
        return vipDoMapper.updateVip(vipDo);
    }
    @Override
    //添加员工信息
    public Integer addVip(VipDo vipDo) {
        return vipDoMapper.addVip(vipDo);
    }


}
