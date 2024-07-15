package org.example.schooloa.controller;

import org.example.schooloa.entity.Major;
import org.example.schooloa.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/major")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/list")
    public String listMajors(Model model, @RequestParam(name = "message", required = false) String message) {
        List<Major> majors = majorService.getAllMajors();
        model.addAttribute("majors", majors);
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "major/list";
    }

    @GetMapping("/add")
    public String addMajorForm(Model model) {
        model.addAttribute("major", new Major());
        return "major/add";
    }

    @PostMapping("/add")
    public String addMajor(@ModelAttribute Major major) {
        majorService.addMajor(major);
        return "redirect:/major/list";
    }

    @GetMapping("/edit/{id}")
    public String editMajorForm(@PathVariable Long id, Model model) {
        Major major = majorService.getAllMajors().stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("major", major);
        return "major/edit";
    }

    @PostMapping("/edit")
    public String editMajor(@ModelAttribute Major major) {
        majorService.updateMajor(major);
        return "redirect:/major/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteMajor(@PathVariable Long id, Model model) {
        String result = majorService.deleteMajor(id);
        return "redirect:/major/list?message=" + result;
    }
}
