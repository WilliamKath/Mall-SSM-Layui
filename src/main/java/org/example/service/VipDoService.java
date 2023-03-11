package org.example.service;

import org.example.entity.VipDo;
import org.example.vo.VipVo;

import java.util.List;

public interface VipDoService {
    List<VipDo> findAll(VipVo vipVo);

    Integer delVipById(Integer id);

    Integer updateVip(VipDo vipDo);

    Integer addVip(VipDo vipDo);
}
