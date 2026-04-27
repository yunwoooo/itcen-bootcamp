package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyTeamController2 {
    @RequestMapping(value = "/myTeam2", produces = "application/json; charset=utf-8")
    public TeamDTO getTeamInfo() {
        List<TeamMemberVO> list = new ArrayList<TeamMemberVO>();
        TeamMemberVO vo = new TeamMemberVO("강민주", "만두", "샤브샤브");
        list.add(vo);
        vo = new TeamMemberVO("김민수", "간치순", "라멘");
        list.add(vo);
        vo = new TeamMemberVO("김윤우", "유누", "곱창");
        list.add(vo);
        vo = new TeamMemberVO("이현석", "이언덕", "김치찌개");
        list.add(vo);

        TeamDTO v1 = new TeamDTO();
        v1.setTeamName("우주수석");
        v1.setTeamMember(list);

        return v1;
    }
}
