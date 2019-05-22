package com.qst.demo.controller;


import com.qst.demo.bean.User;
import com.qst.demo.commen.Result;
import com.qst.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    /*页面跳转*/
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return "page";
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "lizifu");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody()
    public Result<User> dbGet() {

        User user = userService.getById(1);
        return Result.success(user);

    }

    @RequestMapping("/db/tx")
    @ResponseBody()
    public Result<Boolean> dbTx() {

        boolean tx = userService.tx();
        return Result.success(true);

    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        this.userService.addUser(user);
        return "ok";
    }
    /*查询所有员工*/
    @RequestMapping("/showAllUser")
    public String findAllUser(Model model) {
        List<User> list = userService.fingAllUser();
        model.addAttribute("list",list);
        return "showUser";
    }

}
