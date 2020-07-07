package com.xuanke1.dao;

import com.xuanke1.bean.E;
import com.xuanke1.bean.O;
import com.xuanke1.bean.T;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {

    @Select("select t.gh,t.xm,t.xb,d.mc,t.csrq,t.xl,t.jbgz from t,d where t.yxh=d.yxh")
    public List<T> getTAll();

    @Select("select yxh from d where mc=#{mc}")
    public String getDyxh(@Param("mc") String mc);

    @Select("select t.gh,t.xm,t.xb,d.mc,t.csrq,t.xl,t.jbgz from t,d where t.yxh=d.yxh and t.gh=#{gh}")
    public T getTbyGh(@Param("gh") String gh);

    @Update("update t set xm=#{xm},xb=#{xb},yxh=#{yxh},xl=#{xl},csrq=#{csrq},jbgz=#{jbgz} where gh=#{gh}")
    public void updateT(@Param("gh") String gh,@Param("xm") String xm,@Param("xb") String xb,@Param("yxh") String yxh,@Param("xl") String xl,@Param("csrq") String csrq,@Param("jbgz") float jbgz);



    @Select("select password from user where username=#{username}")
    public String getUpwdByName(@Param("username") String username);

    @Update("update user set password=#{password} where username=#{username}")
    public void updateUpwd(@Param("username") String username,@Param("password") String password);


    @Select("select DISTINCT(e.kh),c.km,o.sksj,c.xf,e.xq from e,c,o where e.kh=c.kh and e.kh=o.kh and o.gh=#{gh} and e.gh=#{gh}")
    public List<O> getEot(@Param("gh") String gh);

    @Select("select DISTINCT(e.kh),c.km,o.sksj,c.xf,e.xq from e,c,o where e.kh=c.kh and e.kh=o.kh and o.gh=#{gh} and e.gh=#{gh} and e.zpcj<0")
    public List<O> getEotd(@Param("gh") String gh);

    @Select("select DISTINCT(e.kh),c.km,o.sksj,c.xf,e.xq from e,c,o where e.kh=c.kh and e.kh=o.kh and o.gh=#{gh} and e.gh=#{gh} and e.zpcj>0")
    public List<O> getEotg(@Param("gh") String gh);

    @Select("select e.kh,e.gh,e.xh,s.xm,e.pscj,e.kscj from s,e where e.xh=s.xh and e.gh=#{gh} and e.kh=#{kh}")
    public List<E> getEbyGhXh(@Param("kh") String kh,@Param("gh") String gh);

    @Update("update e set pscj=#{pscj},kscj=#{kscj},zpcj=#{zpcj} where gh=#{gh} and kh=#{kh} and xh=#{xh}")
    public void updateEgrade(@Param("gh") String gh,@Param("kh") String kh,@Param("xh") String xh,@Param("pscj") float pscj,@Param("kscj") float kscj,@Param("zpcj") float zpcj);



}
