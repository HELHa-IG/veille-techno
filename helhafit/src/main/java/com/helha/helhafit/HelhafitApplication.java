package com.helha.helhafit;

import com.helha.helhafit.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class HelhafitApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HelhafitApplication.class, args);
/*		for (String bean: context.getBeanDefinitionNames()) {
			System.out.println("#"+bean);
		}*/
	}
}
