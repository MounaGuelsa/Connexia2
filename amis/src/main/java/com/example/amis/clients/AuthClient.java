package com.example.amis.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth", url = "${application.config.students-url}")
public interface AuthClient {

}
