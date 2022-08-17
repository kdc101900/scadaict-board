package com.scadaict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // AOP 사용을 위한 어노테이션
public class ScadaictBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScadaictBoardApplication.class, args);
	}

}
