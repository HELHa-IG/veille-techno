package com.helha.helhafit.services;

import com.helha.helhafit.models.Member;
import org.springframework.data.domain.Page;

public interface IMemberService {
    public Page<Member> findAll();
    public Page<Member> findAll(int pageSize, int offset, String sortBy);
    public Page<Member> find(String keyword);
    public Member add(Member member);
}
