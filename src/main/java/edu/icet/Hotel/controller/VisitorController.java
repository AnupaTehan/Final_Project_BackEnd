package edu.icet.Hotel.controller;


import edu.icet.Hotel.dto.Visitor;
import edu.icet.Hotel.service.VisitorService;
import lombok.RequiredArgsConstructor;
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
    public boolean addNewVisitor(@RequestBody Visitor visitor){
        if (visitor == null) {
            return false;
        }
        visitorService.addNewVisitor(visitor);
        return  true;
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
