package org.example.controller;

import com.alibaba.fastjson.JSON;
import org.example.entity.User;
import org.example.entity.UserDo;
import org.example.service.UserService;
import org.example.vo.ResMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    public HttpSession session;
    
    @RequestMapping("/Login")
    @ResponseBody
    public String Login(String username, String password, HttpSession session){
        //创建map集合保存信息
        Map<String,Object> map = new HashMap<String,Object>();
        //调用登录的方法
        User loginUser = userService.Login(username, password);
        //判断对象是否为空
        if(loginUser!=null){
            //保存会话
            session.setAttribute("loginUser",loginUser);
            map.put("success",true);//成功
        }else{
            map.put("success",false);//失败
        }
        //将Map集合的数据以JSON格式返回
        return JSON.toJSONString(map);
    }
    @RequestMapping("/Signup")
    @ResponseBody
    public ResMsg Register(String username, String password){
        ResMsg resMsg = new ResMsg();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //调用查询用户名是否存在方法
        if (!userService.existUsername(username)){
            if (userService.addUser(user)){
                resMsg.setCode(0);
                resMsg.setMsg("注册成功");
            } else {
                resMsg.setCode(1);
                resMsg.setMsg("注册失败！");
            }
        } else {
            resMsg.setCode(2);
            resMsg.setMsg("用户名已存在！");
        }
        return resMsg;
    }
}
