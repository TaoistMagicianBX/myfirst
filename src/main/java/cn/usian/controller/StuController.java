package cn.usian.controller;

import cn.usian.pojo.Student;
import cn.usian.service.StuService;
import cn.usian.vo.StuVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class StuController {

    @Autowired
    StuService stuService;

    @RequestMapping("show")
    public String show(Model model, StuVo stuVo, @RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "1") Integer pageSize){
      PageInfo<Student> pageInfo = stuService.findAll(stuVo,pageNum,pageSize);
      model.addAttribute("page",pageInfo);
      model.addAttribute("stu",stuVo);


        return "show";
    }
    @RequestMapping("/zhuce")
    public String zhuce(){

        return "zhuce";
    }
    @RequestMapping("/toadd")
    public String toadd(){

        return "add";
    }
    @RequestMapping("/zc")
    public String zc(Student stu){
        System.out.println(stu);
        stuService.zc(stu);

        return "redirect:/show";
    }

   @RequestMapping("/add")
    public String add(Student stu){
       System.out.println(stu);
       stuService.add(stu);

        return "redirect:/show";
    }


    @RequestMapping("/findByname")
    @ResponseBody
    public String findByname(Student stu){
        List<Student> list = stuService.findByname(stu);
        if (list.size()>0){
            return "1";

        }else {
            return "0";
        }



    }


  @RequestMapping("delete")
    public String  delete(Integer id){
            stuService.delete(id);
        return "redirect:/show";
    }

      @RequestMapping("findById")
    public String findById(Integer id,Model model){
        Student student =stuService.findById(id);
        model.addAttribute("stu",student);
        return "update";
    }
    @RequestMapping("update")
    public String update(Student stu){
        stuService.update(stu);

        return "redirect:/show";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String Login(StuVo s, Model model, HttpServletRequest request){
        StuVo stu=stuService.findS(s);

        request.getSession().setAttribute("stu",stu);
        if(stu!=null){
            return "redirect:/show";
        }else{
            model.addAttribute("error","账号或者密码错误");
            return "login";
        }

    }
}
