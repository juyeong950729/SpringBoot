package kr.co.farmstory.controller;

import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("user/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("user/terms")
    public String terms(Model model) {
        TermsVO vo = service.selectTerms();
        model.addAttribute("vo", vo);
        return "user/terms";
    }

    @GetMapping("user/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("user/register")
    public String register(UserVO vo, HttpServletRequest req){
        vo.setRegip(req.getRemoteAddr());
        int result = service.insertUser(vo);
        return "redirect:/user/login";
    }



}
