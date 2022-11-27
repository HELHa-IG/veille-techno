package com.helha.helhafit.controllers;

import com.helha.helhafit.models.Member;
import com.helha.helhafit.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    IMemberService service;

    @GetMapping
    public String getMembers(Model model,String keyword){
        model.addAttribute("welcomeMsg","Welcome on Members page");
        if(keyword != null){
            model.addAttribute("members",this.service.find(keyword));
            model.addAttribute("keyword",keyword);
        }else{
            model.addAttribute("members",this.service.findAll());
            model.addAttribute("keyword","");
        }
        return "members";
    }

    @GetMapping("/add")
    public String getNewMember(Model model){
        model.addAttribute("member",new Member());
        return "addMember";
    }


    @PostMapping("/add")
    public String addNewMember(Member member,Model model){
        this.service.add(member);
        return "redirect:/members";
    }
}
