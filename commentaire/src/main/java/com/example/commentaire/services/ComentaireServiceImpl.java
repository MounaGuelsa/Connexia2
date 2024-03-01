package com.example.commentaire.services;

import com.example.commentaire.Client.NotificatonClient;
import com.example.commentaire.dto.ComentaireDto;
import com.example.commentaire.entity.Comentaire;
import com.example.commentaire.repository.ComentaireRepository;
import com.example.notification.dto.NotificationDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentaireServiceImpl implements ComentaireService {

    private final ComentaireRepository comentaireRepository;
    private final ModelMapper modelMapper;
//    private NotificatonClient notificatonClient ;

    @Autowired
    public ComentaireServiceImpl(ComentaireRepository comentaireRepository, ModelMapper modelMapper) {
        this.comentaireRepository = comentaireRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ComentaireDto> getAllComentairesByidPost(long id) {
        List<Comentaire> comentaires = comentaireRepository.findAllById_post(id);
        return comentaires.stream()
                .map(comentaire -> modelMapper.map(comentaire, ComentaireDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public ComentaireDto getComentaireById(Long id) {
        Optional<Comentaire> comentaireOptional = comentaireRepository.findById(id);
        return comentaireOptional.map(comentaire -> modelMapper.map(comentaire, ComentaireDto.class)).orElse(null);
    }
    @Override
    public ComentaireDto createComentaire(ComentaireDto comentaireDto) {
        Comentaire comentaire = modelMapper.map(comentaireDto, Comentaire.class);
        Comentaire savedComentaire = comentaireRepository.save(comentaire);
        return modelMapper.map(savedComentaire, ComentaireDto.class);
    }
    @Override
 /*   public ComentaireDto updateComentaire(Long id, ComentaireDto comentaireDto) {
        Comentaire existingComentaire = comentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentaire not found with id: " + id));
        existingComentaire.setContent(comentaireDto.getContent());
        Comentaire updatedComentaire = comentaireRepository.save(existingComentaire);
        return modelMapper.map(updatedComentaire, ComentaireDto.class);
    }*/
    public ComentaireDto updateComentaire(Long id, ComentaireDto comentaireDto) {
        comentaireDto.setId(id);
        return modelMapper.map(comentaireRepository.save(modelMapper.map(comentaireDto, Comentaire.class)), ComentaireDto.class);
    }
    @Override
    public void deleteComentaire(Long id) {
        Comentaire existingComentaire = comentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentaire not found with id: " + id));
        existingComentaire.setIsdeleted(true);
        comentaireRepository.save(existingComentaire);
    }
}
