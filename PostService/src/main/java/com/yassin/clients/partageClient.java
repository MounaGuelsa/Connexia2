package com.yassin.clients;

import com.example.partage.dtos.PartageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface partageClient {
    @GetMapping("/{id}")
    public ResponseEntity<PartageDto> getPartageById(@PathVariable Long id);
}