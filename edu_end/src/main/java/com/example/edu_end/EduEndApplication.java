package com.example.edu_end;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.edu_end.mapper")
public class EduEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduEndApplication.class, args);
    }

}
