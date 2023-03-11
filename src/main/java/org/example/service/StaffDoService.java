package org.example.service;

import org.example.entity.StaffDo;
import org.example.vo.StaffVo;
import java.util.List;

public interface StaffDoService {
    //查找方法
    List<StaffDo> findAll(StaffVo staffVo);
    
    Integer delStaffById(Integer id);

    Integer delWagesById(Integer id);

    Integer updateStaff(StaffDo staffDo);

    Integer addStaff(StaffDo staffDo);

    Integer addOneWages();
}
