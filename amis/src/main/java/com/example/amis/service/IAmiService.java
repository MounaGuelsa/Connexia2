package com.example.amis.service;

import com.example.amis.dto.AmiDto;
import com.example.amis.entity.Ami;

import java.util.List;
import java.util.Optional;

public interface IAmiService {
    AmiDto saveAmi(AmiDto amiDto);
    List<AmiDto> getAllAmi();
    Optional<AmiDto> getAmiById(Long id);
    void deleteAmi (Long id);
    Optional<AmiDto> getEmetteur(Long id);
    Ami accepterDemandeAmi(Long idAmi) ;
    AmiDto ajouterAmi(Long idRecepteur, Long idEmetteur);


}
