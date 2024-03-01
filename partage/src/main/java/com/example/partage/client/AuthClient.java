package com.example.partage.client;

import com.javatechie.entity.UserCredential;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth", url = "${application.config.students-url}")
public interface AuthClient {

    @GetMapping("/getUserByName")
    ResponseEntity<UserCredential> getUserByName(@RequestHeader("username") String username);
}
