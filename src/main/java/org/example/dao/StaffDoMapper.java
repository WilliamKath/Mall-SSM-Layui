package org.example.dao;

import org.example.entity.StaffDo;
import org.example.vo.StaffVo;
import java.util.List;

public interface StaffDoMapper {
    //查询所有及条件查询
    List<StaffDo> findAll(StaffVo staffVo);
    //通过ID删除员工信息
    Integer delStaffById(Integer id);
    Integer delWagesById(Integer id);
    //通过ID更改员工信息
    Integer updateStaff(StaffDo staffDo);
    //添加员工信息
    Integer addStaff(StaffDo staffDo);
    //添加员工时自动添加一条工资
    Integer addOneWages();
}