package com.example.amis.controller;

import com.example.amis.dto.AmiDto;
import com.example.amis.service.IAmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amis")
public class AmiController {
    private final IAmiService iAmiService;

    @Autowired
    public AmiController(IAmiService iAmiService) {
        this.iAmiService = iAmiService;
    }
    @PostMapping("/save")
    public ResponseEntity<AmiDto> saveAmi(@RequestBody AmiDto amiDto){
        AmiDto savedAmi = iAmiService.saveAmi(amiDto);
        return new ResponseEntity<>(savedAmi, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AmiDto>> getAllAmis(){
        List<AmiDto> amis =iAmiService.getAllAmi();
        return ResponseEntity.ok(amis);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AmiDto> getAmiById(@PathVariable Long id){
        Optional<AmiDto> amiOptional = iAmiService.getAmiById(id);
        return amiOptional.map(amiDto -> new ResponseEntity<>(amiDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmi(@PathVariable Long id){
        iAmiService.deleteAmi(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
