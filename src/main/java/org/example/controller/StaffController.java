package org.example.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.entity.StaffDo;
import org.example.service.StaffDoService;
import org.example.vo.ResMsg;
import org.example.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    
    @Autowired
    StaffDoService staffDoService;

    /**
     * 查询所有数据及条件查询
     * @param staffVo
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ResMsg findAll (StaffVo staffVo) {
        ResMsg resMsg = new ResMsg();
        //设置分页信息（当前页码，每页显示数量）
        PageHelper.startPage(staffVo.getPage(),staffVo.getLimit());
        //调用分页查询列表的方法
        List<StaffDo> list = staffDoService.findAll(staffVo);
        if ( list == null ){
            resMsg.setCode(1);
            resMsg.setMsg("获取数据失败");
        } else {
            //创建分页对象
            PageInfo<StaffDo> pageInfo = new PageInfo<StaffDo>(list);
            /*
            返回数据
            此处getTotal于getList为pageInfo自带get方法
            */
            resMsg.setCount(pageInfo.getTotal());   //总记录数
            resMsg.setData(pageInfo.getList());     //获取的数据
            resMsg.setMsg("获取数据成功");
        }
        return resMsg;
    }
    
    /**
     * 通过ID删除员工信息
     * @param id
     * @return
     */
    @RequestMapping("/delOne")
    public ResMsg delStaff(Integer id){
        ResMsg resMsg = new ResMsg();
        int result = staffDoService.delStaffById(id);
        if ( result > 0 ){
            staffDoService.delWagesById(id);
            resMsg.setCode(0);
            resMsg.setMsg("删除成功");
        } else {
            resMsg.setCode(1);
            resMsg.setMsg("删除失败");
        }
        return resMsg;
    }

    /**
     * 批量删除
     * @param ids(String类型需要进行转换)
     * @return
     */
    @RequestMapping("/batchDel")
    public ResMsg batchDelete(String ids){
        ResMsg resMsg = new ResMsg();
        int count = 0;
        //将字符串拆分成数组
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            count = staffDoService.delStaffById(Integer.valueOf(idsStr[i]));
            staffDoService.delWagesById(Integer.valueOf(idsStr[i]));
            if(count>0){
                resMsg.setCode(0);
                resMsg.setMsg("批量删除成功");
            }
        }
        //判断受影响行数是否为0
        if(count<=0){
            resMsg.setCode(1);
            resMsg.setMsg("批量删除失败");
        }
        return resMsg;
    }

    /**
     * 通过ID修改员工信息
     * @param staffDo
     * @return
     */
    @RequestMapping("/updateOne")
    public ResMsg updateStaff(StaffDo staffDo){
        ResMsg resMsg = new ResMsg();
        int result = staffDoService.updateStaff(staffDo);
        if (result > 0){
            resMsg.setCode(0);
            resMsg.setMsg("修改成功");
        } else {
            resMsg.setCode(1);
            resMsg.setMsg("修改失败");
        }
        return resMsg;
    }

    /**
     * 添加员工信息
     * @param staffDo
     * @return
     */
    @RequestMapping("/addOne")
    public ResMsg addStaff(StaffDo staffDo){
        ResMsg resMsg = new ResMsg();
        int result = staffDoService.addStaff(staffDo);
        if (result > 0){
            staffDoService.addOneWages();
            resMsg.setCode(0);
            resMsg.setMsg("添加成功");
        } else {
            resMsg.setCode(1);
            resMsg.setMsg("添加失败");
        }
        return resMsg;
    }
}

