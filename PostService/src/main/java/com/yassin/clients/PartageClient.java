package com.yassin.clients;

import com.example.partage.dtos.PartageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "c",path = "http://localhost:8092")
public interface PartageClient {
    @GetMapping("/{id}")
     ResponseEntity<PartageDto> getPartageById(@PathVariable Long id);
}
