package com.xuanke1.dao;

import com.xuanke1.bean.E;
import com.xuanke1.bean.S;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinfoDao {
    @Select("select s.xh,s.xm,s.xb,s.csrq,s.sjhm,d.mc from s,d where s.yxh=d.yxh and xh=#{xh}")
    public List<S> getSinfo(@Param("xh") String xh);

    @Update("update s set xb=#{xb},csrq=#{csrq},sjhm=#{sjhm} where xh=#{xh}")
    public void updateSinfo(@Param("xh") String xh,@Param("xb") String xb,@Param("csrq") String csrq,@Param("sjhm") String sjhm);

    @Select("select password from user where username=#{username}")
    public String getSpwd(@Param("username") String username);

    @Update("update user set password=#{password} where username=#{username}")
    public void updateSpwd(@Param("username") String username,@Param("password") String password);
}
