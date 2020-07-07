package com.xuanke1.dao;

import com.xuanke1.bean.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AdminDao {

    //调用存储过程返回学生总人数
    @Select({ "call procedure_total_student(#{map.total,mode=OUT,jdbcType=INTEGER})" })
    @Results({
            @Result(column="total", property="total", jdbcType= JdbcType.INTEGER)
    })
    @Options(statementType= StatementType.CALLABLE)
    public void getSNum(@Param("map") HashMap map);

    @Select("select yxh from d where mc=#{mc}")
    public String getDyxh(@Param("mc") String mc);

    //添加学生
    @Insert("insert into s(xh,xm,xb,csrq,sjhm,yxh) values(#{xh}, #{xm}, #{xb}, #{csrq},#{sjhm},#{yxh})")
    public void insertS(@Param("xh") String xh,@Param("xm") String xm,@Param("xb") String xb,@Param("csrq") String csrq,@Param("sjhm") String sjhm,@Param("yxh") String yxh);

    @Insert("insert into user(username,password,role) values(#{username}, #{password}, #{role})")
    public void insertUserS(@Param("username") String username,@Param("password") String password,@Param("role") String role);

    //添加老师
    @Insert("insert into t(gh,xm,xb,csrq,yxh,xl,jbgz) values(#{gh}, #{xm}, #{xb}, #{csrq},#{yxh},#{xl},#{jbgz})")
    public void insertT(@Param("gh") String gh,@Param("xm") String xm,@Param("xb") String xb,@Param("csrq") String csrq,@Param("yxh") String yxh,@Param("xl") String xl,@Param("jbgz") float jbgz);

    @Insert("insert into user(username,password,role) values(#{username}, #{password}, #{role})")
    public void insertUserT(@Param("username") String username,@Param("password") String password,@Param("role") String role);

    //添加课程
    @Insert("insert into c(kh,km,xf,xs,yxh) values(#{kh}, #{km}, #{xf}, #{xs},#{yxh})")
    public void insertC(@Param("kh") String kh,@Param("km") String km,@Param("xf") int xf,@Param("xs") int xs,@Param("yxh") String yxh);

    //添加开课课程
    @Insert("insert into o(kh,gh,xq,sksj) values(#{kh},#{gh},#{xq},#{sksj})")
    public void insertO(@Param("kh") String kh,@Param("gh") String gh,@Param("xq") String xq,@Param("sksj") String sksj);

    //添加学院
    @Insert("insert into d(yxh,mc,dz,lxdh) values(#{yxh},#{mc},#{dz},#{lxdh})")
    public void insertD(@Param("yxh") String yxh,@Param("mc") String mc,@Param("dz") String dz,@Param("lxdh") String lxdh);




    @Select("select xh from s")
    public List<S> getSxhAll();

    @Select("select gh from t")
    public List<T> getTghAll();

    @Select("select kh from c")
    public List<C> getCkhAll();

    @Select("select kh,gh from o")
    public List<O> getOkhghAll();

    @Select("select yxh from d")
    public List<D> getDyxhAll();

    @Select("select mc from d")
    public List<D> getDmcAll();

    @Select("select s.xh,s.xm,s.xb,d.mc,s.csrq,s.sjhm from s,d where s.yxh=d.yxh")
    public List<S> getSAll();

    @Delete("delete from s where xh=#{xh} ")
    public void deleteS(@Param("xh") String xh);

    @Update("update s set xm=#{xm},xb=#{xb},yxh=#{yxh},sjhm=#{sjhm},csrq=#{csrq} where xh=#{xh}")
    public void updateS(@Param("xh") String xh,@Param("xm") String xm,@Param("xb") String xb,@Param("yxh") String yxh,@Param("sjhm") String sjhm,@Param("csrq") String csrq);



    @Select("select t.gh,t.xm,t.xb,d.mc,t.csrq,t.xl,t.jbgz from t,d where t.yxh=d.yxh")
    public List<T> getTAll();

    @Delete("delete from t where gh=#{gh} ")
    public void deleteT(@Param("gh") String gh);

    @Update("update t set xm=#{xm},xb=#{xb},yxh=#{yxh},xl=#{xl},csrq=#{csrq},jbgz=#{jbgz} where gh=#{gh}")
    public void updateT(@Param("gh") String gh,@Param("xm") String xm,@Param("xb") String xb,@Param("yxh") String yxh,@Param("xl") String xl,@Param("csrq") String csrq,@Param("jbgz") float jbgz);


    @Select("select c.kh,c.km,c.xf,c.xs,d.mc from c,d where c.yxh=d.yxh")
    public List<C> getCAll();

    @Delete("delete from c where kh=#{kh} ")
    public void deleteC(@Param("kh") String kh);

    @Select("select * from d")
    public List<D> getDAll();

    @Delete("delete from d where yxh=#{yxh} ")
    public void deleteD(@Param("yxh") String yxh);

    @Update("update d set mc=#{mc},dz=#{dz},lxdh=#{lxdh} where yxh=#{yxh}")
    public void updateD(@Param("yxh") String yxh,@Param("mc") String mc,@Param("dz") String dz,@Param("lxdh") String lxdh);



    @Select("select * from o")
    public List<O> getOAll();

    @Delete("delete from o where kh=#{kh} and gh=#{gh} and xq=#{xq}")
    public void deleteO(@Param("kh") String kh,@Param("gh") String gh,@Param("xq") String xq);

    @Select("select password from user where username=#{username}")
    public String getUserpwd(@Param("username") String username);

    @Update("update user set password=#{password} where username=#{username}")
    public void updateUserpwd(@Param("username") String username,@Param("password") String password);


}
