package com.example.AuthentificationService.client;

import com.example.users.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@FeignClient(path = "http://localhost:8088/users",name = "auth")
public interface UtilisateurCilient {
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) ;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id);

}
