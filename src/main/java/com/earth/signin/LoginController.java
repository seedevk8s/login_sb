package com.earth.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //@RequestMapping("/login/login")
    //@RequestMapping(value = "/login/login", method = RequestMethod.GET)
    @GetMapping("/login/login")
    public String showlogin() {
        return "login";         //login.html
    }

    // 하나의 메서드로 GET, POST 둘다 처리하는 경우
    //@RequestMapping(value = "/login/login", method = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/login/login")
    public String login(String id, String pwd) {
        // 1. id, pwd를 확인
        if (loginCheck(id, pwd)) {
            // 2. 일치하면, userInfo.html
            return "userInfo";              // userInfo.html
        } else {
            //    일치하지 않으면, login.html로 이동
            return "redirect:/login/login";
        }

    }

    private boolean loginCheck(String id, String pwd) {
        return ("earth").equals(id) && ("0629").equals(pwd);

    }
}


