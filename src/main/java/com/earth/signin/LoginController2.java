package com.earth.signin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController2 {

    //@RequestMapping("/login/login")
    //@RequestMapping(value = "/login/login", method = RequestMethod.GET)
    @GetMapping("/login2")
    public String showLogin() {
        return "login";         //login.html
    }

    // 하나의 메서드로 GET, POST 둘다 처리하는 경우
    //@RequestMapping(value = "/login/login", method = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/login2")
    public String login(String id, String pwd, Model model) throws UnsupportedEncodingException {
        // 1. id, pwd를 확인
        if (loginCheck(id, pwd)) {
            // 2. 일치하면, userInfo.html
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);

            return "userInfo";              // userInfo.html
        } else {
            //    일치하지 않으면, login.html로 이동
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8" ) ;
            return "redirect:/login/login2?msg="+msg;        //GET 요청 - URL 재작성
        }

    }

    private boolean loginCheck(String id, String pwd) {
        return ("earth").equals(id) && ("0629").equals(pwd);

    }
}


