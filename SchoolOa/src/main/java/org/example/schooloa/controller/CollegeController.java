package org.example.schooloa.controller;

import org.example.schooloa.entity.College;
import org.example.schooloa.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/list")
    public String listColleges(Model model) {
        List<College> colleges = collegeService.getAllColleges();
        model.addAttribute("colleges", colleges);
        return "college/list";
    }

    @GetMapping("/add")
    public String addCollegeForm(Model model) {
        model.addAttribute("college", new College());
        return "college/add";
    }

    @PostMapping("/add")
    public String addCollege(@ModelAttribute College college) {
        collegeService.addCollege(college);
        return "redirect:/college/list";
    }

    @GetMapping("/edit/{id}")
    public String editCollegeForm(@PathVariable Long id, Model model) {
        College college = collegeService.getAllColleges().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("college", college);
        return "college/edit";
    }

    @PostMapping("/edit")
    public String editCollege(@ModelAttribute College college) {
        collegeService.updateCollege(college);
        return "redirect:/college/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCollege(@PathVariable Long id, Model model) {
        String result = collegeService.deleteCollege(id);
        model.addAttribute("message", result);
        return "redirect:/college/list";
    }
}
