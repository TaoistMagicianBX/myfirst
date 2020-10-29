package cn.usian.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("e")
public class DemoController {


    @RequestMapping("index")
    public String index(){
        int i = 2/0;

        return "index";
    }
    @RequestMapping("index1")
    public String index1(){
      String str = null;
              str.length();

        return "index";
    }
}
