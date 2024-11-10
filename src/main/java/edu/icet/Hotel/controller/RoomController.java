package edu.icet.Hotel.controller;


import edu.icet.Hotel.dto.Room;
import edu.icet.Hotel.dto.Visitor;
import edu.icet.Hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/room")

public class RoomController {

    private  final RoomService roomService;

    @PostMapping("/addNew-room")
    public boolean addNewVisitor(@RequestBody Room room){
        if (room == null) {
            return false;
        }
        roomService.addNewRoom(room);
        return  true;
    }

    @GetMapping("/getAll-room")
    public List<Room> getAllVisitors(){
        return roomService.getAllRooms();
    }



    @PutMapping("/changeAvailability")
    public ResponseEntity<String> changeRoomAvailability(@RequestBody Map<String, Object> request) {
        Long roomId = request.get("roomId") != null ? Long.valueOf(request.get("roomId").toString()) : null;
        String availability = (String) request.get("availability");

        if (roomId == null || availability == null) {
            return ResponseEntity.badRequest().body("Room ID and availability are required.");
        }
        boolean updated = roomService.updateRoomAvailability(roomId, availability);

        if (updated) {
            return ResponseEntity.ok("Room availability updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found or update failed.");
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {
        List<Room> availableRooms = roomService.getAvailableRooms();
        return ResponseEntity.ok(availableRooms);
    }



}
