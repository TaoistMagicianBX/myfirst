package cn.usian.mapper;

import cn.usian.pojo.Student;
import cn.usian.vo.StuVo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface StuMapper extends BaseMapper<Student> {


    List<Student> findAll(StuVo stuvo);

    /*@Insert("insert into student values(null,#{name},#{sid},#{sex},#{birthday})")
    void add(Student stu);

    @Delete("delete from student where id=#{id}")
    void delete(Integer id);

    @Select("select * from student where id=#{id}")
    Student findById(Integer id);

    @Update("update student set name=#{name},sid=#{sid},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void update(Student stu);*/
    @Select("select * from student where name=#{name} and sid=#{sid} ")
    StuVo findS(StuVo s);

    @Insert("insert into student values(null,#{name},#{sid},#{sex},#{birthday})")
    void zc(Student stu);

    @Select("select * from student where name=#{name}")
    List<Student> findByname(Student stu);
}
