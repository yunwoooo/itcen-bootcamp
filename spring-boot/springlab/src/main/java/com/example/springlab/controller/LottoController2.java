package com.example.springlab.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LottoController2 {
    @RequestMapping(value="/lotto2")
    public String lotto_proc(int imgNum, HttpSession s, Model model, HttpServletRequest req) {
        Integer count = (Integer) s.getAttribute("count");
        if (count == null) count = 0;
        if (count >= 3) {
            s.setAttribute("result", "로또 응모는 낙첨된 경우에 한하여 3번 까지만 가능합니다.<br> 브라우저를 재기동한 후에 응모해 주세요.");
            s.setAttribute("imgName", "snow");
            return "lottoView2";
        }

        final int ran_num = (int) (Math.random() * 6) + 1;
        System.out.println("고른 숫자: " + imgNum + ", 추출된 숫자: " + ran_num);


        if (imgNum == ran_num) {
            s.setAttribute("result", "추카추카!!");
            s.setAttribute("imgName", "sun");
        } else {
            count++;
            s.setAttribute("count", count);
            s.setAttribute("result", "아쉽네요.. 다음 기회를!!");
            s.setAttribute("imgName", "rain");
            model.addAttribute("refinfo", req.getHeader("referer"));
        }
        return "lottoView2";
    }
}
