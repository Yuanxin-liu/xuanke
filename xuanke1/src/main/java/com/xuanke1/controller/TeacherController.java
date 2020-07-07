package com.xuanke1.controller;

import com.alibaba.fastjson.JSON;
import com.xuanke1.bean.*;
import com.xuanke1.dao.SinfoDao;
import com.xuanke1.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherDao td;
    List<T> lt;
    List<O> loe;
    List<O> loed;
    List<O> loeg;
    List<E> le;

    //教师教授的所有课程
    @RequestMapping("/eCourseT")
    public String eCourseT(){

        String gh=User.getUsername();
        String flag="error";
        loe=td.getEot(gh);
        System.out.println("list ecourse:"+loe);

        HashMap<String,Object> res=new HashMap();
        if(loe!=null) flag="true";


        res.put("flag",flag);
        res.put("loe",loe);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //需要登分的课程
    @RequestMapping("/eCourseTd")
    public String eCourseTd(){

        String gh=User.getUsername();
        String flag="error";
        loed=td.getEotd(gh);
        //System.out.println("list ecourse:"+loed);

        HashMap<String,Object> res=new HashMap();
        if(loed!=null) flag="true";


        res.put("flag",flag);
        res.put("loed",loed);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //需要改分的课程
    @RequestMapping("/eCourseTg")
    public String eCourseTg(){

        String gh=User.getUsername();
        String flag="error";
        loeg=td.getEotg(gh);
        System.out.println("list ecourse:"+loeg);

        HashMap<String,Object> res=new HashMap();
        if(loeg!=null) flag="true";


        res.put("flag",flag);
        res.put("loeg",loeg);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //获取教师信息
    @RequestMapping("/tinfo")
    public String getTinfo(){

        String gh= User.getUsername();
        String flag="error";
        T t=td.getTbyGh(gh);
        System.out.println("t:"+t);

        HashMap<String,Object> res=new HashMap();
        if(t!=null) flag="true";


        res.put("flag",flag);
        res.put("t",t);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //更新教师信息
    @RequestMapping("/updateTinfo")
    public String updateTinfo(@RequestBody T t){
//        String xh=s.getXh();
//        String xb=s.getXb();
//        String csrq=s.getCsrq();
//        String sjhm=s.getSjhm();
//
//        System.out.println("s:"+s);
//        System.out.println("xh:"+xh);
//        System.out.println("xb:"+xb);
//        System.out.println("csrq:"+csrq);
//        System.out.println("sjhm:"+sjhm);
        String flag="error";
        String yxh=td.getDyxh(t.getMc());
        td.updateT(t.getGh(),t.getXm(),t.getXb(),yxh,t.getXl(),t.getCsrq(),t.getJbgz());
        flag="true";


        return flag;

    }

    //修改教师密码
    @RequestMapping("/updateTpwd")
    public boolean updateTpwd(@RequestBody HashMap<String,String> mpwd){


        System.out.println("mpwds:"+mpwd);

        String oldpass=mpwd.get("oldpass");
        String pass=mpwd.get("checkPass");
        String gh=User.getUsername();
        String cpass=td.getUpwdByName(gh);

        System.out.println("oldpass"+oldpass);
        System.out.println("pass:"+pass);

        System.out.println("gh:"+gh);
        System.out.println("cpass:"+cpass);
        if(!oldpass.equals(cpass)){
            return false;
        }
//        System.out.println("sjhm:"+sjhm);
        boolean flag=false;
        td.updateUpwd(gh,pass);
        flag=true;


        return flag;

    }



    //根据课号得到该课程的选课信息
    @RequestMapping("/es")
    public String getEbyKhGh(@RequestBody String kh){
        String gh=User.getUsername();

        String jkh=kh.substring(0,2);
        System.out.println("gh:"+gh);
        System.out.println("kh:"+kh);
        System.out.println("jkh:"+jkh);
        String flag="error";
        le=td.getEbyGhXh(jkh,gh);
        System.out.println("le:"+le);

        if(le!=null) flag="true";


        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("le",le);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //修改分数
    @RequestMapping("/upegrade")
    public String updateEgrade(@RequestBody List<E> le1){
        System.out.println("le1:"+le1);
        String flag="error";
        String gh=User.getUsername();
        String kh=this.le.get(0).getKh();
        System.out.println("kh:"+kh);
        System.out.println("gh:"+gh);

        for(int i=0;i<le1.size();i++){
            E te=le1.get(i);
            System.out.println("te:"+te);
            if(te.getXh()!=null){
                td.updateEgrade(gh,kh,te.getXh(),te.getPscj(),te.getKscj(),te.getZpcj());
                System.out.println("sjgx");
                flag="true";
            }
        }

        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("le",le);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

}
