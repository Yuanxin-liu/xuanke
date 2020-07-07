package com.xuanke1.dao;

import com.xuanke1.bean.E;
import com.xuanke1.bean.O;
import com.xuanke1.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectCourseDao {
//    @Select("select * from user where username=#{username} and password=#{password}")
//    public User getUserByMessage(@Param("username") String username, @Param("password") String password);

    @Select("select * from o where kh=#{kh} and gh=#{gh} and xq=#{xq}")
    public O getObyKhGhXq(@Param("kh") String kh,@Param("gh") String gh,@Param("xq") String xq);

    @Select("select o.kh,c.km,o.gh,t.xm,d.mc,o.sksj,c.xf,o.xq from c,o,t,d where o.kh=c.kh and o.gh=t.gh and c.yxh=d.yxh")
    public List<O> getOpenCourse();

    @Insert("insert into e(xh, xq,kh,gh,zpcj,pscj,kscj) values(#{xh}, #{xq}, #{kh}, #{gh},#{zpcj},#{pscj},#{kscj})" )
    public void insrtE(@Param("xh") String xh,@Param("xq") String xq,@Param("kh") String kh,@Param("gh") String gh,@Param("zpcj") float zpcj,@Param("pscj") float pscj,@Param("kscj") float kscj);

    @Select("select * from e where xh=#{xh}")
    public List<E> getE(@Param("xh") String xh);

    @Select("select o.kh,c.km,t.gh,t.xm,d.mc,o.sksj,c.xf,o.xq from e,c,t,d,o where o.kh=c.kh and o.gh=t.gh and c.yxh=d.yxh and e.kh=o.kh and e.gh=o.gh and e.xh=#{xh}")
    public List<O> getEo(@Param("xh") String xh);

    @Delete("delete from e where xh=#{xh} and xq=#{xq} and kh=#{kh} and gh=#{gh}")
    public void deleteE(@Param("xh") String xh,@Param("xq") String xq,@Param("kh") String kh,@Param("gh") String gh);

//    @Select({"<script>",
//            "SELECT zpcj FROM e",
//            "WHERE xh=#{xh}",
//            "<when test='zpcj!=null'>",
//            "AND xq=#{xq}",
//            "AND kh=#{kh}",
//            "AND gh=#{gh}",
//            "</when>",
//            "</script>"})
    @Select("select * from e where xh=#{xh} and xq=#{xq} and kh=#{kh} and gh=#{gh}")
    public E getEcj(@Param("xh")String xh,@Param("xq") String xq,@Param("kh") String kh,@Param("gh") String gh);

}
