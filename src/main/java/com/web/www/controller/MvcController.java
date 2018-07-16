package com.web.www.controller;


import com.web.www.entity.HelloWorld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.SunHints;

@Controller
//@RequestMapping(value = "/home")
public class MvcController {

//    向后台传值的方法
    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value = "welcome_name")
    public String welcome_name(String name){
        System.out.println("[WebDemo]:Name is "+name);
        return "welcome";
    }

    @RequestMapping("welcome_param")
    public String welcome_param(@RequestParam(value = "username",required = false) String name){
        System.out.println("[WebDemo]:Name is "+name);
        return "welcome";
    }

//    向前台传值的方法
    @RequestMapping(value = "/welcome_model")
    public String welcome_model(String name,Model model){
        System.out.println("[WebDemo]:name is "+name);
        model.addAttribute("username","use username get value is"+name);
        return "welcome";
    }

    @RequestMapping(value = "/welcome_view")
    public ModelAndView welcome_view(String name){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("view value");
        ModelAndView view = new ModelAndView();
        view.addObject("username",name);
        view.addObject("helloWorld",helloWorld);
        view.setViewName("welcome");
        return view;
    }



}
