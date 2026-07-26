package com.crud;

import com.crud.LooseCouple.Mains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CrudJpaApplication {

    //http://localhost:1111/swagger-ui/index.html
    public static void main(String[] args) {

        SpringApplication.run(CrudJpaApplication.class, args);
    }

}
