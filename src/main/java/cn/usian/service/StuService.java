package cn.usian.service;


import cn.usian.mapper.StuMapper;
import cn.usian.pojo.Student;
import cn.usian.vo.StuVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService {

    @Autowired
    StuMapper stuMapper;

    public PageInfo<Student> findAll(StuVo stuVo, Integer pageNum, Integer pageSize) {


        PageHelper.startPage(pageNum,pageSize);

        List<Student> list =stuMapper.findAll(stuVo);


        return new PageInfo<Student>(list);
    }

    public void add(Student stu) {

        /*add(stu);*/
        stuMapper.insert(stu);
    }

    public void delete(Integer id) {
        /*delete(id);*/
        stuMapper.deleteByPrimaryKey(id);
    }

    public Student findById(Integer id) {
        /*stuMapper.findById(id);*/
       return stuMapper.selectByPrimaryKey(id);
    }

    public void update(Student stu) {
        /*stuMapper.update(stu);*/
        stuMapper.updateByPrimaryKey(stu);
    }

    public StuVo findS(StuVo s) {

        return stuMapper.findS(s);
    }

    public void zc(Student stu) {
        stuMapper.zc(stu);
    }

    public List<Student> findByname(Student stu) {
        return stuMapper.findByname(stu);
    }
}
