package com.example.interaction.controller;

import com.example.interaction.dto.InteractionDto;
import com.example.interaction.services.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interactions")
public class InteractionController {

    private final InteractionService interactionService;

    @Autowired
    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @GetMapping
    public ResponseEntity<List<InteractionDto>> getAllInteractions() {
        List<InteractionDto> interactions = interactionService.getAllInteractions();
        return new ResponseEntity<>(interactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteractionDto> getInteractionById(@PathVariable Long id) {
        InteractionDto interaction = interactionService.getInteractionById(id);
        if (interaction != null) {
            return new ResponseEntity<>(interaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InteractionDto> createInteraction(@RequestBody InteractionDto interactionDto) {
        InteractionDto createdInteraction = interactionService.createInteraction(interactionDto);
        return new ResponseEntity<>(createdInteraction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InteractionDto> updateInteraction(@PathVariable Long id, @RequestBody InteractionDto interactionDto) {
        InteractionDto updatedInteraction = interactionService.updateInteraction(id, interactionDto);
        return new ResponseEntity<>(updatedInteraction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
