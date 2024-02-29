package com.example.partage.client;

import com.example.users.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "http://localhost:8088/user")
@Component
public interface CompteCilient {
    @GetMapping("/{id}")
     ResponseEntity<UserDto> getUserById(@PathVariable Long id) ;
}
