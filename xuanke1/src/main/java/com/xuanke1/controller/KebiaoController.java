package com.xuanke1.controller;

import com.alibaba.fastjson.JSON;
import com.xuanke1.bean.E;
import com.xuanke1.bean.O;
import com.xuanke1.bean.User;
import com.xuanke1.dao.SelectCourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class KebiaoController {
    @Autowired
    SelectCourseDao scd;
    List<O> lo;
    List<O> loe;
    User u;
    List<E> le;

    //获取所有选课信息
    @RequestMapping("/eCourseList")
    public String eCourseList(){

        String xh=User.getUsername();
        String flag="error";
        loe=scd.getEo(xh);
        System.out.println("list ecourse:"+loe);

        HashMap<String,Object> res=new HashMap();
        if(loe!=null) flag="true";


        res.put("flag",flag);
        res.put("loe",loe);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }
}
