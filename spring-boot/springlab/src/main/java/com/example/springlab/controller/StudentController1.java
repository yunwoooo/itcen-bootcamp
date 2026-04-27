package com.example.springlab.controller;

import com.example.springlab.domain.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import mybatis.dao.StudentMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class StudentController1 {
    @Autowired
    StudentMapper1 st;

    @GetMapping("/test1")
    public ModelAndView listAll() {
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list = st.listAll();
        mav.addObject("list", list);
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test2")
    public ModelAndView listOrderByScoreDesc() {
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list = st.listOrderByScoreDesc();
        mav.addObject("list", list);
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test3")
    public ModelAndView listByScoreGreaterEqualThan70() {
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list = st.listByScoreGreaterEqualThan70();
        mav.addObject("list", list);
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test4")
    public ModelAndView listByContainName() {
        ModelAndView mav = new ModelAndView();
        List<StudentDTO> list = st.listByContainName();
        mav.addObject("list", list);
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test5")
    public ModelAndView getScore(String name) {
        ModelAndView mav = new ModelAndView();
        Integer score = st.getScore(name);
        if (score != null)
            mav.addObject("msg", name + "학생은 " + score + "점이네요..");
        else
            mav.addObject("msg", "이름이 "+name+"인 학생은 없어요~~");
        mav.setViewName("studentView1");
        return mav;
    }
    @GetMapping("/test6")
    public ModelAndView getScoreAvg() {
        ModelAndView mav = new ModelAndView();
        double num = st.getScoreAvg();
        mav.addObject("num", num);
        mav.setViewName("studentView1");
        return mav;
    }
}
