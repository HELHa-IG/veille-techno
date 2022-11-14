package com.helha.helhafit.repos;

import com.helha.helhafit.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface IMemberRepository extends JpaRepository<Member, Integer>{
    Page<Member> findAll(Pageable pageable);

    @Query("SELECT m FROM Member m WHERE CONCAT(upper(m.name),upper(m.firstname),upper(m.email),upper(m.iban)) like CONCAT('%',upper(?1),'%')")
    Page<Member> find(String keyword,Pageable pageable);
}
