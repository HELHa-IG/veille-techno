package com.helha.helhafit.controllers;

import com.helha.helhafit.models.Member;
import com.helha.helhafit.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberRESTController {

    @Autowired
    IMemberService service;

    @GetMapping
    public Page<Member> getMembers(@RequestParam(defaultValue = "10",required = false) int pageSize,
                                   @RequestParam(defaultValue = "0",required = false) int offset,
                                   @RequestParam(defaultValue = "name ASC",required = false) String sortBy){
        return this.service.findAll(pageSize,offset,sortBy);
    }

    @PostMapping
    public Member addMember(@RequestBody Member member){
        return this.service.add(member);
    }
}
