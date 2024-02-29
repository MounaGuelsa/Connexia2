package com.example.amis.service;

import com.example.amis.dto.AmiDto;
import com.example.amis.entity.Ami;
import com.example.amis.repository.AmiRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AmiServiceImpl implements IAmiService{
    private final AmiRepository amiRepository;
    private final ModelMapper modelMapper;

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


}
