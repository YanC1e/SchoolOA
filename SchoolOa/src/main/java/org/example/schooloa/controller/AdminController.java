package org.example.schooloa.controller;

import org.example.schooloa.entity.Admin;
import org.example.schooloa.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Admin admin, HttpSession session, Model model) {
        Admin loggedInAdmin = adminService.login(admin.getUsername(), admin.getPassword());
        if (loggedInAdmin != null) {
            session.setAttribute("user", loggedInAdmin);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Admin user = (Admin) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "home";
    }
}
