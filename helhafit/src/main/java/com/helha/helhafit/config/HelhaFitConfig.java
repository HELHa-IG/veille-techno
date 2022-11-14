package com.helha.helhafit.config;

import com.helha.helhafit.models.Member;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class HelhaFitConfig {

    @Value("${helhafit.api.paging.pageSize:5}")
    public static String DEFAULT_PAGESIZE;

    @Value("${helhafit.api.paging.offset:0}")
    public static String DEFAULT_OFFSET;

    @Bean
    public ArrayList<Member> getMembers(){
        ArrayList<Member> members = new ArrayList<>() {{
           add(new Member(1,"Redzhebov","Birdzhan","la209667@student.helha.be"));
            add(new Member(2,"Leseigneur","Julien","la02158151@student.helha.be"));
            add(new Member(3,"Doe","John","john.doe@gmail.com"));
            add(new Member(4,"Bigrassssss","Mathis","brigasssss.mathis@gmail.com"));
        }};

        return members;
    }

}
