package com.helha.helhafit.services;

import com.helha.helhafit.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberServiceInMemoryImpl implements IMemberService {

    @Autowired
    ArrayList<Member> members;

    public Page<Member> findAll(){
        return null;
    }

    @Override
    public Page<Member> findAll(int pageSize, int offset, String sortBy) {
        return null;
    }

    @Override
    public Page<Member> find(String keyword) {
        return null;
    }

    public Member add(Member member){
        member.setId(this.members.size()+1);
        this.members.add(member);

        return member;
    }
}
