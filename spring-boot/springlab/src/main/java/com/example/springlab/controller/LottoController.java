package com.example.springlab.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LottoController {
    @RequestMapping(value="/lotto")
    public ModelAndView lotto_proc(int imgNum, HttpServletRequest req) {
        final int ran_num = (int) (Math.random() * 6) + 1;
        System.out.println("고른 숫자: " + imgNum + ", 추출된 숫자: " + ran_num);
        ModelAndView mav = new ModelAndView();

        if (imgNum == ran_num) {
            mav.addObject("result", "추카추카!!");
            mav.addObject("imgName", "sun");
        } else {
            mav.addObject("result", "아쉽네요.. 다음 기회를!!");
            mav.addObject("imgName", "rain");
            mav.addObject("refinfo", req.getHeader("referer"));
        }
        mav.setViewName("lottoView");
        return  mav;
    }
}
