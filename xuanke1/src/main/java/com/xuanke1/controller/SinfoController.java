package com.xuanke1.controller;

import com.alibaba.fastjson.JSON;
import com.xuanke1.bean.E;
import com.xuanke1.bean.O;
import com.xuanke1.bean.S;
import com.xuanke1.bean.User;
import com.xuanke1.dao.SelectCourseDao;
import com.xuanke1.dao.SinfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SinfoController {
    @Autowired
    SinfoDao sd;
    List<S> ls;


    //获取学生信息
    @RequestMapping("/sinfo")
    public String getSinfo(){

        String xh=User.getUsername();
        String flag="error";
        ls=sd.getSinfo(xh);
        System.out.println("list s:"+ls);

        HashMap<String,Object> res=new HashMap();
        if(ls!=null) flag="true";


        res.put("flag",flag);
        res.put("ls",ls);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //修改学生信息
    @RequestMapping("/updateSinfo")
    public String updateSinfo(@RequestBody S s){

        String xh=s.getXh();
        String xb=s.getXb();
        String csrq=s.getCsrq();
        String sjhm=s.getSjhm();
//
//        System.out.println("s:"+s);
//        System.out.println("xh:"+xh);
//        System.out.println("xb:"+xb);
//        System.out.println("csrq:"+csrq);
//        System.out.println("sjhm:"+sjhm);
        String flag="error";
        sd.updateSinfo(xh,xb,csrq,sjhm);
        flag="true";


        return flag;

    }

    //修改学生密码
    @RequestMapping("/updateSpwd")
    public boolean updateSpwd(@RequestBody HashMap<String,String> mpwd){


        //System.out.println("mpwds:"+mpwd);

        String oldpass=mpwd.get("oldpass");
        String pass=mpwd.get("checkPass");
        String xh=User.getUsername();
        String cpass=sd.getSpwd(xh);

//        System.out.println("oldpass"+oldpass);
//        System.out.println("pass:"+pass);

//        System.out.println("xh:"+xh);
//        System.out.println("cpass:"+cpass);
        //判断输入密码是否正确
        if(!oldpass.equals(cpass)){
            return false;
        }
//        System.out.println("sjhm:"+sjhm);
        boolean flag=false;
        sd.updateSpwd(xh,pass);
        flag=true;


        return flag;

    }

}
