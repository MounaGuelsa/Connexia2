package com.example.partage.controller;
import com.example.partage.dtos.PartageDto;
import com.example.partage.services.PartageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partages")
public class PartageController {

    private final PartageService partageService;

    @Autowired
    public PartageController(PartageService partageService) {
        this.partageService = partageService;
    }

    @GetMapping
    public ResponseEntity<List<PartageDto>> getAllPartages() {
        List<PartageDto> partages = partageService.getAllPartages();
        return ResponseEntity.ok(partages);
    }
    @GetMapping("post/{id}")
    public ResponseEntity<List<PartageDto>> findAllByIdPost(@PathVariable Long id) {
        List<PartageDto> partages = partageService.findAllByIdPost(id);
        return ResponseEntity.ok(partages);
    }
    @GetMapping("partageurList/{id}")
    public ResponseEntity<List<PartageDto>> findAllByIdPartageur(@PathVariable Long id) {
        List<PartageDto> partages = partageService.findAllByIdPartageur(id);
        return ResponseEntity.ok(partages);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PartageDto> getPartageById(@PathVariable Long id ) {
        return partageService.getPartageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PartageDto> savePartage(@RequestBody PartageDto partageDTO , @RequestHeader(name = "username") String username ) {
        PartageDto savedPartage = partageService.savePartage(partageDTO,username);
        return new ResponseEntity<>(savedPartage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartageById(@PathVariable Long id) {
        partageService.deletePartageById(id);
        return ResponseEntity.noContent().build();
    }
}
