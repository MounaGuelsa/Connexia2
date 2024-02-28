package com.example.partage.services;

import com.example.notification.dto.NotificationDto;
import com.example.partage.client.CompteCilient;
import com.example.partage.client.notificatonClient;
import com.example.partage.dtos.PartageDto;
import com.example.partage.entities.Partage;
import com.example.partage.repositories.PartageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartageService {
    @Autowired
    private  PartageRepository partageRepository;

    @Autowired
    private  ModelMapper modelMapper;
    private notificatonClient notificatonClient;
    @Autowired
    private CompteCilient compteCilient;

    // Méthode pour récupérer tous les partages avec mapping vers PartageDTO
    public List<PartageDto> getAllPartages() {
        List<Partage> partages = partageRepository.findAll();
        return partages.stream()
                .map(partage -> modelMapper.map(partage, PartageDto.class))
                .collect(Collectors.toList());
    }

    // Méthode pour récupérer un partage par son ID avec mapping vers PartageDTO
    public Optional<PartageDto> getPartageById(Long id) {
        Optional<Partage> partageOptional = partageRepository.findById(id);
        return partageOptional.map(partage -> modelMapper.map(partage, PartageDto.class));
    }

    // Méthode pour enregistrer un partage avec mapping depuis PartageDTO
//    public PartageDto savePartage(PartageDto partageDTO) {
//        Partage partage = modelMapper.map(partageDTO, Partage.class);
//        Partage savedPartage = partageRepository.save(partage);
//        var userDto = compteCilient.getUserById(partage.getIdPartageur());
//        generateNotification(userDto.getBody().getNom(),);
//        return modelMapper.map(savedPartage, PartageDto.class);
//    }
    public List<PartageDto> findAllByIdPartageur(Long id) {
        List<Partage> partages = partageRepository.findAllByIdPartageur(id);
        return partages.stream()
                .map(partage -> modelMapper.map(partage, PartageDto.class))
                .collect(Collectors.toList());
    }
    public List<PartageDto> findAllByIdPost(Long id) {
        List<Partage> partages = partageRepository.findAllByIdPost(id);
        return partages.stream()
                .map(partage -> modelMapper.map(partage, PartageDto.class))
                .collect(Collectors.toList());
    }
public void generateNotification(String nom , String nom2){
    NotificationDto notificationDto = new NotificationDto() ;
    notificationDto.setMessage(nom+ " a patager un post de " +nom2);
    notificatonClient.saveNotification(notificationDto);
}
    // Méthode pour supprimer un partage par son ID
    public void deletePartageById(Long id) {
        partageRepository.deleteById(id);
    }
}
