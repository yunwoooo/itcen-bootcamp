package com.example.springlab.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalcController {
    @RequestMapping(value="/calc")
    public ModelAndView cal_proc(int num1, int num2, String oper, HttpServletRequest req) {
        System.out.println(num1 + ", " + num2 + ", " + oper);
        ModelAndView mav = new ModelAndView();
        int result = 0;
        mav.addObject("refinfo", req.getHeader("referer"));
        if (oper.equals("/") && num2 == 0) {
            mav.addObject("message", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!");
            mav.setViewName("errorResult");
            return mav;
        }
        if (oper.equals("/")) {
            result = num1 / num2;
        } else if (oper.equals("+")) {
            result = num1 + num2;
        } else if (oper.equals("-")) {
            result = num1 - num2;
        } else {
            result = num1 * num2;
        }
        mav.addObject("result", result);
        mav.setViewName("calcResult");
        return  mav;
    }

}
