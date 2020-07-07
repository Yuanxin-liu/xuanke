package com.xuanke1.controller;

import com.alibaba.fastjson.JSON;
import com.xuanke1.bean.E;
import com.xuanke1.bean.O;
import com.xuanke1.bean.User;
import com.xuanke1.dao.SelectCourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SelectCourseController {
    @Autowired
    SelectCourseDao scd;
    List<O> lo;
    List<O> loe;
    User u;
    List<E> le;


    //获得开课表内容
    @RequestMapping("/openCourse")
    public String openCourse(){

        String flag="error";
        //获得开课表的内容
        lo=scd.getOpenCourse();
//        System.out.println("list opencourse:"+lo);

        //将开课表返回前端
        HashMap<String,Object> res=new HashMap();
        if(lo!=null) flag="true";

        res.put("flag",flag);
        res.put("lo",lo);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //学生选课
    @RequestMapping("/selectCourse")
    public String selectCourse(@RequestBody O oc){
        int i=0;
        boolean flag;
        flag=true;
        String res="error";
        System.out.println("oc:"+oc);
        //当前用户的用户名即学号
        String xh=User.getUsername();
        System.out.println("xh:"+xh);

        //获取该学生所选的所有课程
        le=scd.getE(xh);
        System.out.println("le:"+le);

        //选课时间冲突无法选课
        for(i=0;i<le.size();i++){
            E te=le.get(i);
            O to=scd.getObyKhGhXq(te.getKh(),te.getGh(),te.getXq());
            System.out.println("to:"+to);
            String sksj=to.getSksj();
            String sksj2=oc.getSksj();
            String z=sksj.substring(0,2);
            String z2=sksj2.substring(0,2);

            System.out.println("z:"+z);
            System.out.println("z2:"+z2);
            System.out.println("z.equals(z2):"+z.equals(z2));
            if(z.equals(z2)){
                String m1=sksj.substring(2,4);
                String m2=sksj.substring(5,7);
                String n1=sksj2.substring(2,4);
                String n2=sksj2.substring(5,7);
                System.out.println("n1:"+n1);
                System.out.println("n2:"+n2);
                System.out.println("m2.compareTo(n1):"+m2.compareTo(n1));
                System.out.println("m1:"+m1);
                System.out.println("m2:"+m2);
                System.out.println("n2.compareTo(m1):"+n2.compareTo(m1));
                if(m2.compareTo(n1)<0||n2.compareTo(m1)<0)
                    ;
                else
                    flag=false;

            }

            if(sksj.length()>8){
                String zh=sksj.substring(7,9);
                if(zh.equals(z2)){
                    String a1=sksj.substring(9,11);
                    String a2=sksj.substring(12,14);
                    String m1=sksj2.substring(2,4);
                    String m2=sksj2.substring(5,7);
                    System.out.println("a1:"+a1);
                    System.out.println("a2:"+a2);
                    System.out.println("m2.compareTo(a1):"+m2.compareTo(a1));
                    System.out.println("m1:"+m1);
                    System.out.println("m2:"+m2);
                    System.out.println("a2.compareTo(m1):"+a2.compareTo(m1));
                    if(m2.compareTo(a1)<0||a2.compareTo(m1)<0)
                        ;
                    else
                        flag=false;
                }
            }

            if(sksj2.length()>8){
                String zh=sksj2.substring(7,9);
                if(zh.equals(z)){
                    String a1=sksj2.substring(9,11);
                    String a2=sksj2.substring(12,14);
                    String m1=sksj.substring(2,4);
                    String m2=sksj.substring(5,7);
                    System.out.println("a1:"+a1);
                    System.out.println("a2:"+a2);
                    System.out.println("m2.compareTo(a1):"+m2.compareTo(a1));
                    System.out.println("m1:"+m1);
                    System.out.println("m2:"+m2);
                    System.out.println("a2.compareTo(m1):"+a2.compareTo(m1));
                    if(m2.compareTo(a1)<0||a2.compareTo(m1)<0)
                        ;
                    else
                        flag=false;
                }
            }

            if(sksj.length()>8&&sksj2.length()>8){
                String xqd=sksj.substring(7,9);
                String xqd2=sksj2.substring(7,9);
                if(xqd.equals(xqd2)){
                    String a1=sksj.substring(9,11);
                    String a2=sksj.substring(12,14);
                    String b1=sksj2.substring(9,11);
                    String b2=sksj2.substring(12,14);
                    if(a2.compareTo(b1)<0&&b2.compareTo(a1)<0)
                        ;
                    else
                        flag=false;
                }

            }

        }


        //所选课程如果课号相同，则无法加入选课表
        for(i = 0;i < le.size();i++){
            E et = le.get(i);
            System.out.println("et:"+et);
            System.out.println(xh.equals(et.getXh()));
            System.out.println(oc.getXq().equals(et.getXq()));
            if(xh.equals(et.getXh()) && oc.getXq().equals(et.getXq()) && oc.getKh().equals(et.getKh())){
                flag=false;
                System.out.println("same data");
            }


        }
        System.out.println(flag);

        if(flag){
            scd.insrtE(xh,oc.getXq(),oc.getKh(),oc.getGh(),-1,-1,-1);
            System.out.println("添加数据成功");
            res="true";

        }
        System.out.println(res);

        return res;

    }

    @RequestMapping("/eCourse")
    public String eCourse(){

        String flag="error";
        String xh=User.getUsername();
        loe=scd.getEo(xh);
        System.out.println("list ecourse:"+loe);

        HashMap<String,Object> res=new HashMap();
        if(loe!=null) flag="true";


        res.put("flag",flag);
        res.put("loe",loe);

        String res_json= JSON.toJSONString(res);
        return res_json;

    }

    //学生退课
    @RequestMapping("/quitCourse")
    public String quitCourse(@RequestBody O oc){
        float cj;
        String res="error";
        //学生学号
        String xh=User.getUsername();

        System.out.println("oc:"+oc);
        System.out.println("xh:"+xh);
        System.out.println("kh:"+oc.getKh());
        System.out.println("xq:"+oc.getXq());
        System.out.println("gh:"+oc.getGh());


        //获取退课课程的成绩
        E e=scd.getEcj(xh,oc.getXq(),oc.getKh(),oc.getGh());
        System.out.println("e:"+e);
        cj=e.getZpcj();

        //如果该课程未登分，可退课
        if(cj<0){
            scd.deleteE(xh,oc.getXq(),oc.getKh(),oc.getGh());
            System.out.println("已经删除");
            res="true";

        }



        System.out.println(res);

        return res;

    }

}
