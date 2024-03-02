package com.example.partage.services;
import com.example.notification.dto.NotificationDto;
import com.example.partage.client.AuthClient;
import com.example.partage.client.NotificatonClient;
import com.example.partage.client.PostClient;
import com.example.partage.dtos.PartageDto;
import com.example.partage.entities.Partage;
import com.example.partage.repositories.PartageRepository;
import com.javatechie.entity.UserCredential;
import com.yassin.dto.ImagePostDto;
import com.yassin.model.ImagePost;
import com.yassin.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartageService {
    @Autowired
    private  PartageRepository partageRepository;

    @Autowired
    private  ModelMapper modelMapper;
     private NotificatonClient notificatonClient ;
     private AuthClient compteCilient;
     private PostClient postClient ;

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

//     Méthode pour enregistrer un partage avec mapping depuis PartageDTO
    public PartageDto savePartage(PartageDto partageDTO , String username) {
        Partage partage = modelMapper.map(partageDTO, Partage.class);
        var user =  compteCilient.getUserByName(username);
        partage.setIdPartageur(user.getBody().getId());
        postPartage(partageDTO);
        Partage savedPartage = partageRepository.save(partage);
        return modelMapper.map(savedPartage, PartageDto.class);
    }
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
    public Long getId(String username){
      var user =  compteCilient.getUserByName(username);
        return (long) user.getBody().getId();
    }
public void generateNotification(String nom ){
    NotificationDto notificationDto = new NotificationDto() ;
    notificationDto.setMessage(nom+ " a patager un post  " );
    notificatonClient.saveNotification(notificationDto);
}
public void  postPartage(PartageDto partageDTO){
       var post = postClient.getPostById(partageDTO.getIdPost());
       ImagePostDto post1 = new ImagePostDto();
       post1.setTitle(post.getBody().getTitle());
       post1.setShared(true);
       post1.setPublishDate(LocalDateTime.now().now());
       post1.setUserId(partageDTO.getIdPartageur());
       postClient.createPost(post1);
}
    // Méthode pour supprimer un partage par son ID
    public void deletePartageById(Long id) {
        partageRepository.deleteById(id);
    }
}
