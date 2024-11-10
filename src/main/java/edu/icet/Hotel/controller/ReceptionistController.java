package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.Receptionist;
import edu.icet.Hotel.service.ReceptionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/receptionist")
public class ReceptionistController {

    final ReceptionistService receptionistService;

    @PostMapping("/login")
    public boolean login(@RequestBody Receptionist receptionist) {
        boolean isValid = receptionistService.validateCredentials(receptionist);
        return isValid;
    }

}
