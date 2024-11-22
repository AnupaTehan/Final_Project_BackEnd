package edu.icet.hotel.service.impl;

import edu.icet.hotel.dto.OnlineVisitorLogin;
import edu.icet.hotel.repository.OnlineVisitorRepository;
import edu.icet.hotel.service.OnlineVisitorLoginService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor

public class OnlineVisitorLoginServiceImpl implements OnlineVisitorLoginService {

    private final OnlineVisitorRepository onlineVisitorRepository;

    final ModelMapper modelMapper;

    @Override
    public boolean validateCredentials(OnlineVisitorLogin onlineVisitorLogin) {
        // Log inputs for debugging
        System.out.println("Validating email: " + onlineVisitorLogin.getEmailAddressOnl());
        System.out.println("Validating ID Number: " + onlineVisitorLogin.getIdNumberOnl());

        boolean present = onlineVisitorRepository.findByEmailAddressOnlAndIdNumberOnl(
                onlineVisitorLogin.getEmailAddressOnl(), onlineVisitorLogin.getIdNumberOnl()).isPresent();
        return present;
    }
}
