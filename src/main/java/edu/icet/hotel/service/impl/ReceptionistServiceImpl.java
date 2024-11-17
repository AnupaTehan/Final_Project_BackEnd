package edu.icet.hotel.service.impl;

import edu.icet.hotel.dto.Receptionist;
import edu.icet.hotel.entity.ReceptionistEntity;
import edu.icet.hotel.repository.ReceptionistRepository;
import edu.icet.hotel.service.ReceptionistService;
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
