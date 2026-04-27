package com.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudyPathController {
    @RequestMapping(value="/study/{number}/thymeleaf")
    public String getAllBoards(@PathVariable("number") int num) {
        if (num == 1)
            return "redirect:https://abbo.tistory.com/56";
        else if (num == 2)
            return "redirect:https://abbo.tistory.com/57";
        else if (num == 3)
            return "redirect:https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html";
        else if (num == 4)
            return "redirect:https://www.baeldung.com/dates-in-thymeleaf";
        return "";
    }
}
