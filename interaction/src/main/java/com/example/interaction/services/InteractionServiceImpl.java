package com.example.interaction.services;

import com.example.interaction.dto.InteractionDto;
import com.example.interaction.entity.Interaction;
import com.example.interaction.repository.InteractionRepository;
import com.example.interaction.services.InteractionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionRepository interactionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public InteractionServiceImpl(InteractionRepository interactionRepository, ModelMapper modelMapper) {
        this.interactionRepository = interactionRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<InteractionDto> getAllInteractions(long id) {
        List<Interaction> interactions = interactionRepository.findAllByPost(id);; // Supposons que tu aies un repository pour les interactions
        return interactions.stream()
                .map(interaction -> modelMapper.map(interaction, InteractionDto.class))
                .collect(Collectors.toList());
    }

    public InteractionDto getInteractionById(Long id) {
        Optional<Interaction> interactionOptional = interactionRepository.findById(id);
        return interactionOptional.map(interaction -> modelMapper.map(interaction, InteractionDto.class)).orElse(null);
    }

    public InteractionDto createInteraction(InteractionDto interactionDto) {
        InteractionDto interactionDto1 ;
        InteractionDto interactionDto2 = interactionRepository.findByPostEtUser(interactionDto.getUser_Id(),interactionDto.getPost_Id()).get();
        if (interactionDto2 !=null){
            interactionDto1 = updateInteraction(interactionDto2.getId() , interactionDto);
        }
        else {
        Interaction interaction = modelMapper.map(interactionDto, Interaction.class);
        Interaction savedInteraction = interactionRepository.save(interaction);
            interactionDto1 = modelMapper.map(savedInteraction, InteractionDto.class);
    }
        return interactionDto1;
    }

    public InteractionDto updateInteraction(Long id, InteractionDto interactionDto) {
        Interaction existingInteraction = interactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interaction not found with id: " + id));

        // Update existingInteraction with fields from interactionDto

        Interaction updatedInteraction = interactionRepository.save(existingInteraction);
        return modelMapper.map(updatedInteraction, InteractionDto.class);
    }
  public Integer NombreInteraction(long id ){
       return interactionRepository.NombreDesInteraction(id);
  }
    public void deleteInteraction(Long id) {
        Interaction existingInteraction = interactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interaction not found with id: " + id));
        existingInteraction.setIsdeleted(true);
        interactionRepository.save(existingInteraction);
    }
}
