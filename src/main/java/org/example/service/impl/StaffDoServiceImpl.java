package org.example.service.impl;

import org.example.dao.StaffDoMapper;
import org.example.entity.StaffDo;
import org.example.service.StaffDoService;
import org.example.vo.StaffVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffDoServiceImpl implements StaffDoService {
    @Resource
    public StaffDoMapper staffDoMapper;

    //查询所有及条件查询
    @Override
    public List<StaffDo> findAll(StaffVo staffVo) {
        return staffDoMapper.findAll(staffVo);
    }

    //通过ID删除员工信息
    @Override
    public Integer delStaffById(Integer id) {
        return staffDoMapper.delStaffById(id);
    }

    @Override
    public Integer delWagesById(Integer id) {
        return staffDoMapper.delWagesById(id);
    }


    //修改员工信息
    @Override
    public Integer updateStaff(StaffDo staffDo) {
        return staffDoMapper.updateStaff(staffDo);
    }

    //添加员工信息
    @Override
    public Integer addStaff(StaffDo staffDo) {
        return staffDoMapper.addStaff(staffDo);
    }

    @Override
    public Integer addOneWages() {
        return staffDoMapper.addOneWages();
    }

}
