package edu.icet.hotel.controller;


import edu.icet.hotel.dto.Visitor;
import edu.icet.hotel.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/visitor")




public class VisitorController {

    private final VisitorService visitorService;



    @PostMapping("/addNew-Visitor")
    public ResponseEntity<String> addNewVisitor(@RequestBody Visitor visitor) {
        if (visitor == null) {
            return ResponseEntity.badRequest().body("Visitor object is null");
        }

        // Validate phone number
        if (!visitor.getPhoneNumber().matches("^07\\d{8}$")) {
            return ResponseEntity.badRequest().body("Invalid phone number. Must start with 07 and be 10 digits long.");
        }

        // Validate email address
        if (!visitor.getEmailAddress().matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
            return ResponseEntity.badRequest().body("Invalid email. Must be a valid Gmail address.");
        }

        // Additional validations (if needed)
        // ...

        // Save visitor if all validations pass
        visitorService.addNewVisitor(visitor);
        return ResponseEntity.ok("Visitor added successfully!");
    }


    @GetMapping("/getAll-visitors")
    public List<Visitor> getAllVisitors(){
        return visitorService.getAllVisitors();
    }

    @GetMapping("/searchByName/{fullName}")
    public Optional<Visitor> searchByName(@PathVariable String fullName ){
        Optional<Visitor> visitor = visitorService.searchVisitor(fullName);
        return visitor;
    }



}
