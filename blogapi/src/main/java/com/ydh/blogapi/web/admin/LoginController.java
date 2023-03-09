package com.ydh.blogapi.web.admin;

import com.ydh.blogapi.po.User;
import com.ydh.blogapi.service.UserService;
import com.ydh.blogapi.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 *  Fish 23-03-08
 */
@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    private UserService userService;

    //到admin后自动跳转login界面
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        //user不为空，说明用户名密码是正确的
        if (user != null) {
            //不把密码传到前面
            user.setPassword(null);
            //将user赋值到session里面 session在服务器端
            session.setAttribute("user",user);
            return "admin/index";
        } else {
            //
            attributes.addFlashAttribute("message", "用户名和密码错误");
            //不能直接返回，需要redirect
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
