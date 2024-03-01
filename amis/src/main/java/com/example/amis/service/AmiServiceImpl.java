package com.example.amis.service;

import com.example.amis.clients.AuthClient;
import com.example.amis.dto.AmiDto;
import com.example.amis.entity.Ami;
import com.example.amis.repository.AmiRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AmiServiceImpl implements IAmiService{
    private final AmiRepository amiRepository;
    private final ModelMapper modelMapper;
    AuthClient authClient;

    @Autowired
    public AmiServiceImpl(AmiRepository amiRepository, ModelMapper modelMapper) {
        this.amiRepository = amiRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AmiDto saveAmi(AmiDto amiDto) {
        Ami ami = modelMapper.map(amiDto,Ami.class);
        Ami savedAmi = amiRepository.save(ami);
        return modelMapper.map(savedAmi,AmiDto.class);

    }

    @Override
    public List<AmiDto> getAllAmi() {
        List<Ami> amis =amiRepository.findAll();
        return amis.stream()
                .map(ami ->modelMapper.map(ami, AmiDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AmiDto> getAmiById(Long id) {
        Optional<Ami> amiOptional=amiRepository.findById(id);
        return amiOptional.map((ami) -> modelMapper.map(ami, AmiDto.class));
    }

    @Override
    public void deleteAmi(Long id) {
        amiRepository.deleteById(id);
    }

    @Override
    public Optional<AmiDto> getEmetteur(Long idEmetteur) {
//        Optional<Ami> amiOptional=amiRepository.findAmiByIdEmetteur(idEmetteur);
//
//        return amiOptional.map((ami)->modelMapper.map(ami,AmiDto.class));
        Optional<Ami> amiOptional = amiRepository.findAmiByIdEmetteur(idEmetteur);

        if (amiOptional.isPresent()) {
            return amiOptional.map((ami) -> modelMapper.map(ami, AmiDto.class));
        } else {
            // Ajoutez un message explicatif ici
            System.out.println("Aucun émetteur trouvé avec l'ID : " + idEmetteur);
            return Optional.empty();
        }
    }

    @Override
    public Ami accepterDemandeAmi(Long idAmi) {
        Ami ami = amiRepository.findById(idAmi).orElse(null);
        if (ami != null) {
            ami.setAccepted(true);
            return amiRepository.save(ami);
        }
        return null;
    }
    @Override
    public AmiDto ajouterAmi(Long idRecepteur, Long idEmetteur) {
        AmiDto ami = new AmiDto();
        ami.setIdRecepteur(idRecepteur);
        ami.setIdEmetteur(idEmetteur);
        ami.setAccepted(false);
        ami.setDeleted(false);
        ami.setBlocked(false);
        return saveAmi(ami);
    }

    @Override
    public List<AuthClient> getAllAcceptedAmis(Long id) {
        List<Ami> amis = amiRepository.findAllByIdEmetteurAndAcceptedTrueAndDeletedFalseAndBlockedFalse(id);
        List<Ami> amis2 = amiRepository.findAllByIdRecepteurAndAcceptedTrueAndDeletedFalseAndBlockedFalse(id);

        List<UserCrednetial> amisUsers = new ArrayList<>();

        for (Ami ami : amis) {
            Long idRecepteur = ami.getIdRecepteur();
            UserCrednetial amiRecepteur = authClient.getUserById(idRecepteur).getBody();
            if (amiRecepteur != null) {
                amisUsers.add(amiRecepteur);
            }
        }
        for (Ami ami :amis2){
            Long idEmetteur =ami.getIdEmetteur();
            UserCrednetial amiEmetteur = authClient.getUserById(idEmetteur).getBody();
            if (amiEmetteur != null ){
                amisUsers.add(amiEmetteur);
            }
        }
        return amisUsers;
    }


}
