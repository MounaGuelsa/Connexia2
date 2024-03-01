package org.example.groupuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GroupUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupUserApplication.class, args);
	}

}
