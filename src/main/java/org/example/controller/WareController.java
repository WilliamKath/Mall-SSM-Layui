package org.example.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.entity.WareDo;
import org.example.service.WareDoService;
import org.example.vo.ResMsg;
import org.example.vo.WareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ware")
public class WareController {

    @Autowired
    WareDoService wareDoService;

    /**
     * 查询所有数据及条件查询
     * @param wareVo
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ResMsg findAll (WareVo wareVo) {
        ResMsg resMsg = new ResMsg();
        //设置分页信息（当前页码，每页显示数量）
        PageHelper.startPage(wareVo.getPage(),wareVo.getLimit());
        //调用分页查询列表的方法
        List<WareDo> list = wareDoService.findAll(wareVo);
        if ( list == null ){
            resMsg.setCode(1);
            resMsg.setMsg("获取数据失败");
        } else {
            //创建分页对象
            PageInfo<WareDo> pageInfo = new PageInfo<WareDo>(list);
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
     * 通过ID删除商品信息
     * @param id
     * @return
     */
    @RequestMapping("/delOne")
    public ResMsg delWare(Integer id){
        ResMsg resMsg = new ResMsg();
        int result = wareDoService.delWareById(id);
        if ( result > 0 ){
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
            count = wareDoService.delWareById(Integer.valueOf(idsStr[i]));
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
     * @param wareDo
     * @return
     */
    @RequestMapping("/updateOne")
    public ResMsg updateWare(WareDo wareDo){
        ResMsg resMsg = new ResMsg();
        int result = wareDoService.updateWare(wareDo);
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

