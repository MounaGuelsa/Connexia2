package com.example.interaction.services;



import com.example.interaction.dto.InteractionDto;
import com.example.interaction.entity.Interaction;

import java.util.List;

public interface InteractionService {
    default List<InteractionDto> getAllInteractions(long id){
        return null;
    }
    default List<InteractionDto> getAllInteractions(){
        return null;
    }
    default InteractionDto getInteractionById(Long id){
        return null;
    }
    default InteractionDto createInteraction(InteractionDto interactionDto){
        return interactionDto;
    }
    default InteractionDto updateInteraction(Long id, InteractionDto interactionDto){
        return interactionDto;
    }
    default void deleteInteraction(Long id){}
}
