package com.ssh.controller;

import com.ssh.entity.User;
import com.ssh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wangli
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public String test(Model model) {
        return "test";
    }

    @RequestMapping("saveUser")
    @ResponseBody
    public String test() {
        Long ret = testService.saveUser();
        if (ret > 0) {
            return "Save Successfully!";
        }
        return "Save Failed!";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<User> getAll() {
        return testService.getAll();
    }
}
