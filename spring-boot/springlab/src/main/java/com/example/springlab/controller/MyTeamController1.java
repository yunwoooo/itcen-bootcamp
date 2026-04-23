package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyTeamController1 {
    @ModelAttribute("myteam")
    public TeamDTO createList(@RequestParam(value = "request", required = false) String request) {
        TeamDTO v1 = new TeamDTO();
        if ("팀명".equals(request)) {
            v1.setTeamName("2팀");
        } else if ("팀원".equals(request)) {
            v1.setTeamName("2팀");
            List<TeamMemberVO> list = new ArrayList<TeamMemberVO>();
            TeamMemberVO vo = new TeamMemberVO("정가영", "쩡가", "초밥");
            list.add(vo);
            vo = new TeamMemberVO("김윤우", "유누", "곱창");
            list.add(vo);
            vo = new TeamMemberVO("이재혁", "재혁", "모든것");
            list.add(vo);
            vo = new TeamMemberVO("안주현", "안주", "햄버거");
            list.add(vo);
            v1.setTeamMember(list);
        }
        return v1;
    }
    @RequestMapping(value="/myTeam1")
    public String handle() {
        return "myTeamView";
    }
}
