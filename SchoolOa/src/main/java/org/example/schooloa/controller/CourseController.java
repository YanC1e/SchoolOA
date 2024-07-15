package org.example.schooloa.controller;

import org.example.schooloa.entity.Course;
import org.example.schooloa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "course/list";
    }

    @GetMapping("/add")
    public String addCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "course/add";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course) {
        courseService.addCourse(course);
        return "redirect:/course/list";
    }

    @GetMapping("/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        Course course = courseService.getAllCourses().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("course", course);
        return "course/edit";
    }

    @PostMapping("/edit")
    public String editCourse(@ModelAttribute Course course) {
        courseService.updateCourse(course);
        return "redirect:/course/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/list";
    }
}
