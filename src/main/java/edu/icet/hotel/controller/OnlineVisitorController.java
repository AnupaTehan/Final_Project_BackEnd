package edu.icet.hotel.controller;

import edu.icet.hotel.dto.OnlineVisitor;
import edu.icet.hotel.dto.Visitor;
import edu.icet.hotel.service.OnlineVisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/online-visitor")
public class OnlineVisitorController {

    private final OnlineVisitorService onlineVisitorService; // Made `final` for Lombok injection

    @PostMapping("/register-new-online-visitor")
    public ResponseEntity<String> registerNewOnlineVisitor(@RequestBody OnlineVisitor onlineVisitor) {

        if (onlineVisitor.getPhoneNumberOnl() == null ||
                !(onlineVisitor.getPhoneNumberOnl().startsWith("07") && onlineVisitor.getPhoneNumberOnl().length() == 10)) {
            return ResponseEntity.badRequest().body("Invalid phone number. Must start with 07 and be 10 digits long.");
        }

        if (onlineVisitor.getEmailAddressOnl() == null ||
                !onlineVisitor.getEmailAddressOnl().matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
            return ResponseEntity.badRequest().body("Invalid email. Must be a valid Gmail address.");
        }

        onlineVisitorService.registerNewOnlineVisitor(onlineVisitor);
        return ResponseEntity.ok("Visitor added successfully!");
    }

    @GetMapping("/getAll-online-visitors")
    public List<OnlineVisitor> getAllOnlineVisitors() {
        return onlineVisitorService.getOnlineVisitors();
    }

    @GetMapping("/searchByName/{fullNameOnl}")
    public Optional<OnlineVisitor> searchByName(@PathVariable String fullNameOnl ){
        Optional<OnlineVisitor> onlineVisitor = onlineVisitorService.searchOnlineVisitor(fullNameOnl);
        return onlineVisitor;
    }
}
