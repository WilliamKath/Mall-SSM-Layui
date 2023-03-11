package org.example.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.entity.WagesDo;
import org.example.service.WagesDoService;
import org.example.vo.ResMsg;
import org.example.vo.WagesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wages")
public class WagesController {
    
    @Autowired
    WagesDoService wagesDoService;

    /**
     * 查询所有数据及条件查询
     * @param wagesVo
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ResMsg findAll (WagesVo wagesVo) {
        ResMsg resMsg = new ResMsg();
        //设置分页信息（当前页码，每页显示数量）
        PageHelper.startPage(wagesVo.getPage(),wagesVo.getLimit());
        //调用分页查询列表的方法
        List<WagesDo> list = wagesDoService.findAll(wagesVo);
        if ( list == null ){
            resMsg.setCode(1);
            resMsg.setMsg("获取数据失败");
        } else {
            //创建分页对象
            PageInfo<WagesDo> pageInfo = new PageInfo<WagesDo>(list);
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
    @RequestMapping("/updateOne")
    public ResMsg updateWages(WagesDo wagesDo){
        ResMsg resMsg = new ResMsg();
        int result = wagesDoService.updateWages(wagesDo);
        if (result > 0){
            resMsg.setCode(0);
            resMsg.setMsg("修改成功");
        } else {
            resMsg.setCode(1);
            resMsg.setMsg("修改失败");
        }
        return resMsg;
    }

}

