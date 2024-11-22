package edu.icet.hotel.controller;

import edu.icet.hotel.dto.OnlineVisitorLogin;
import edu.icet.hotel.service.OnlineVisitorLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/online-visitor-login")



public class OnlineVisitorLoginController {

    final OnlineVisitorLoginService onlineVisitorLoginService;

    @PostMapping("/visitor-login")
    public boolean login(@RequestBody OnlineVisitorLogin onlineVisitorLogin) {
        boolean isValid = onlineVisitorLoginService.validateCredentials(onlineVisitorLogin);
        return isValid;
    }






}
