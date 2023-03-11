package org.example.dao;

import org.example.entity.VipDo;
import org.example.vo.VipVo;

import java.util.List;

public interface VipDoMapper {
    //查询所有及条件查询
    List<VipDo> findAll(VipVo vipVo);
    //通过ID删除员工信息
    Integer delVipById(Integer id);
    //通过ID更改员工信息
    Integer updateVip(VipDo vipDo);
    //添加员工信息
    Integer addVip(VipDo vipDo);

}
