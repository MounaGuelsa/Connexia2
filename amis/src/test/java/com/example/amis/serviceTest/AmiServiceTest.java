package com.example.amis.serviceTest;


import com.example.amis.dto.AmiDto;
import com.example.amis.service.IAmiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AmiServiceTest {
    @Autowired
    private IAmiService iAmiService;

    AmiDto amiDto;

    @BeforeEach
    void setUp(){
        amiDto = new AmiDto();
        amiDto.setId(1L);
        amiDto.setIdRecepteur(2L);
        amiDto.setIdEmetteur(3L);
        amiDto.setAccepted(true);
        amiDto.setDeleted(false);
        amiDto.setBlocked(false);
    }

    @Test
    void saveAmi() {
        AmiDto amiDto1 = iAmiService.saveAmi(amiDto);
        assertNotNull(amiDto1,"Ami Not found");
    }

    @Test
    void getAmis() {
        AmiDto amiDto1 = iAmiService.saveAmi(amiDto);
        List<AmiDto> amiDtoList = iAmiService.getAllAmi();
        assertNotNull(amiDtoList,"list is empty");
    }

    @Test
    void getAmiById() {
        AmiDto amiDto1 =iAmiService.saveAmi(amiDto);
        assertNotNull(amiDto1,"ami not found ");
    }

    @Test
    void deleteAmi() {

        AmiDto amiDto1 = iAmiService.saveAmi(amiDto);

        iAmiService.deleteAmi(amiDto1.getId());

        assertTrue(iAmiService.getAmiById(amiDto1.getId()).isEmpty(), "L'ami devrait être supprimé");
    }
}
