package com.xuanke1.controller;

import com.alibaba.fastjson.JSON;
import com.xuanke1.bean.*;
import com.xuanke1.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminDao ad;
    List<S> ls;
    List<D> ld;
    List<T> lt;
    List<C> lc;
    List<O> lo;
    List<D> ldy;

    //添加学生
    @RequestMapping("/adds")
    public String adds(@RequestBody S s){
        String flag="error";
        boolean k=true;

        //System.out.println("s:"+s);

        //获得所有学生学号
        ls=ad.getSxhAll();

        //如果添加的学生学号不存在，则添加，否则不添加
        for(int i=0;i<ls.size();i++){
            S st=ls.get(i);
            if(s.getXh().equals(st.getXh()))
                k=false;

        }

        //添加学生
        if(k){
            String yxh=ad.getDyxh(s.getMc());
            String role="student";
            ad.insertS(s.getXh(),s.getXm(),s.getXb(),s.getCsrq(),s.getSjhm(),yxh);
            flag="true";

        }

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("s",s);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    //添加课程
    @RequestMapping("/addc")
    public String addc(@RequestBody C c){
        String flag="error";
        boolean k=false;

        //System.out.println("c:"+c);

        lc=ad.getCkhAll();

        //判断课号是否已经存在
        for(int i=0;i<lc.size();i++){
            C tc=lc.get(i);
            if(c.getKh().equals(tc.getKh()))
                k=false;

        }

        //System.out.println("k:"+k);
        //课号不存在，添加该课程
        if(k){
            String yxh=ad.getDyxh(c.getMc());
            ad.insertC(c.getKh(),c.getKm(),c.getXf(),c.getXs(),yxh);
            flag="true";

        }

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("c",c);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    //添加开课课程
    @RequestMapping("/addo")
    public String addo(@RequestBody O o){
        String flag="error";
        boolean k=true;

        //System.out.println("o:"+o);

        lo=ad.getOkhghAll();

        //判断新开的课程是否存在
        for(int i=0;i<lo.size();i++){
            O to=lo.get(i);
            if(o.getKh().equals(to.getKh()))
                k=true;

        }

        //判断该课程是否开过
        for(int i=0;i<lo.size();i++){
            O to=lo.get(i);
            if(o.getKh().equals(to.getKh()) && o.getGh().equals(to.getGh()))
                k=false;

        }

        //System.out.println("k:"+k);
        //如果该课程存在且未开过，添加
        if(k){
            ad.insertO(o.getKh(),o.getGh(),o.getXq(),o.getSksj());
            flag="true";

        }

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("o",o);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    //添加学院
    @RequestMapping("/addd")
    public String addd(@RequestBody D d){
        String flag="error";
        boolean k=true;

        //System.out.println("d:"+d);

        ldy=ad.getDyxhAll();

        //判断学院是否存在
        for(int i=0;i<ldy.size();i++){
            D td=ldy.get(i);
//            System.out.println("td:"+td);
            if(d.getYxh().equals(td.getYxh()))
                k=false;

        }

        //学院不存在，添加
        //System.out.println("k:"+k);
        if(k){
            ad.insertD(d.getYxh(),d.getMc(),d.getDz(),d.getLxdh());
            flag="true";

        }

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("d",d);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    //添加教师
    @RequestMapping("/addt")
    public String addt(@RequestBody T t){
        String flag="error";
        boolean k=true;

        System.out.println("t:"+t);
//        lu=userDao.getUsers();
//        System.out.println("list user:"+lu);
//        System.out.println(user.getUsername());
        //       System.out.println(username);
        lt=ad.getTghAll();

        //判断教师是否存在
        for(int i=0;i<lt.size();i++){
            T tt=lt.get(i);
            if(t.getGh().equals(tt.getGh()))
                k=false;

        }

        //教师不存在，添加
        if(k){
            String yxh=ad.getDyxh(t.getMc());
            String role="teacher";
            ad.insertT(t.getGh(),t.getXm(),t.getXb(),t.getCsrq(),yxh,t.getXl(),t.getJbgz());
            flag="true";

        }

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("t",t);

        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;

    }

    //获取学院名称
    @RequestMapping("/getDmc")
    public String getD(){
        ld=ad.getDmcAll();
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("ld",ld);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获取所有学生
    @RequestMapping("/ls")
    public String getSAll(){
        ls=ad.getSAll();
        System.out.println("ls");
        HashMap<String,Object> map=new HashMap();
        map.put("result", null);
        map.put("total", 0);
        map.put("ls",ls);
        ad.getSNum(map);
        System.out.println("map:"+map);
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("ls",ls);
        res.put("num",map.get("total"));

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //删除学生
    @RequestMapping("/deletes")
    public String deleteS(@RequestBody S s){
        ad.deleteS(s.getXh());
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("s",s);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获取所有教师
    @RequestMapping("/lt")
    public String getTAll(){
        lt=ad.getTAll();
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("lt",lt);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //删除教师
    @RequestMapping("/deletet")
    public String deleteT(@RequestBody T t){
        ad.deleteT(t.getGh());
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("t",t);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获取所有课程
    @RequestMapping("/lc")
    public String getCAll(){
        lc=ad.getCAll();
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("lc",lc);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //删除课程
    @RequestMapping("/deletec")
    public String deleteT(@RequestBody C c){
        //System.out.println("c.kh:"+c.getKh());
        ad.deleteC(c.getKh());
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("c",c);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获取所有学院
    @RequestMapping("/ld")
    public String getDAll(){
        ld=ad.getDAll();
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("ld",ld);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //删除学院
    @RequestMapping("/deleted")
    public String deleteD(@RequestBody D d){
        ad.deleteD(d.getYxh());
        String flag="true";

        //System.out.println("dd");

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("d",d);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获取所有开课课程
    @RequestMapping("/lo")
    public String getOAll(){
        lo=ad.getOAll();
        String flag="true";


        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("lo",lo);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //删除开课课程
    @RequestMapping("/deleteo")
    public String deleteO(@RequestBody O o){
        String flag="error";
        ad.deleteO(o.getKh(),o.getGh(),o.getXq());
        flag="true";

        //System.out.println("dd");

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("o",o);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //修改管理员密码
    @RequestMapping("/updateAdminpwd")
    public boolean updateSpwd(@RequestBody HashMap<String,String> mpwd){


        System.out.println("mpwds:"+mpwd);

        String oldpass=mpwd.get("oldpass");
        String pass=mpwd.get("checkPass");
        String username=User.getUsername();

        String cpass=ad.getUserpwd(username);

//        System.out.println("oldpass"+oldpass);
//        System.out.println("pass:"+pass);
//
//        System.out.println("cpass:"+cpass);
        if(!oldpass.equals(cpass)){
            return false;
        }
//        System.out.println("sjhm:"+sjhm);
        boolean flag=false;
        ad.updateUserpwd(username,pass);
        flag=true;


        return flag;

    }

    //修改教师密码
    @RequestMapping("/uptpwd")
    public boolean updtpwd(@RequestBody HashMap<String,String> mpwd){


        System.out.println("mpwds:"+mpwd);

        boolean k=false;
        String gh=mpwd.get("gh");
        String pass=mpwd.get("checkPass");
        lt=ad.getTghAll();

        for(int i=0;i<lt.size();i++){
            T tt=lt.get(i);
            if(gh.equals(tt.getGh()))
                k=true;
        }

        boolean flag=false;
        if(k){
            ad.updateUserpwd(gh,pass);
            flag=true;

        }

        return flag;

    }

    //修改学生密码
    @RequestMapping("/upspwd")
    public boolean updspwd(@RequestBody HashMap<String,String> mpwd){


        System.out.println("mpwds:"+mpwd);

        boolean k=false;
        String xh=mpwd.get("xh");
        String pass=mpwd.get("checkPass");
        ls=ad.getSxhAll();

        for(int i=0;i<ls.size();i++){
            S ts=ls.get(i);
            if(xh.equals(ts.getXh()))
                k=true;
        }

        boolean flag=false;
        if(k){
            ad.updateUserpwd(xh,pass);
            flag=true;

        }

        return flag;

    }

    //修改学生信息
    @RequestMapping("/ups")
    public String upS(@RequestBody S s){
        //System.out.println("s:"+s);
        String yxh=ad.getDyxh(s.getMc());
        //System.out.println("yxh:"+yxh);

        //修改学生信息
        ad.updateS(s.getXh(),s.getXm(),s.getXb(),yxh,s.getSjhm(),s.getCsrq());
        String flag="true";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("s",s);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //修改学院信息
    @RequestMapping("/upd")
    public String upD(@RequestBody D d){
        //System.out.println("d:"+d);

        //修改学院信息
        ad.updateD(d.getYxh(),d.getMc(),d.getDz(),d.getLxdh());
        String flag="true";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("d",d);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //修改教师信息
    @RequestMapping("/upt")
    public String upS(@RequestBody T t){
        //System.out.println("t:"+t);
        String yxh=ad.getDyxh(t.getMc());
        //System.out.println("yxh:"+yxh);

        //修改教师信息
        ad.updateT(t.getGh(),t.getXm(),t.getXb(),yxh,t.getXl(),t.getCsrq(),t.getJbgz());
        String flag="true";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("t",t);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }


}
