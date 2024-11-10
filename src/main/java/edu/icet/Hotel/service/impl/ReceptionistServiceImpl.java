package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.Receptionist;
import edu.icet.Hotel.entity.ReceptionistEntity;
import edu.icet.Hotel.repository.ReceptionistRepository;
import edu.icet.Hotel.service.ReceptionistService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class ReceptionistServiceImpl implements ReceptionistService {

    final ReceptionistRepository receptionistRepository;

    final ModelMapper modelMapper;

    public boolean validateCredentials(Receptionist receptionist) {
        ReceptionistEntity receptionistEntity = modelMapper.map(receptionist, ReceptionistEntity.class);
        boolean present = receptionistRepository.findByUsernameAndPassword(receptionistEntity.getUsername(), receptionistEntity.getPassword())
                .isPresent();
        return present;
    }

}
