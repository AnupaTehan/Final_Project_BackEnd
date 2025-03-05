package edu.icet.hotel.controller;


import edu.icet.hotel.dto.Room;
import edu.icet.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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





    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {
        List<Room> availableRooms = roomService.getAvailableRooms();
        return ResponseEntity.ok(availableRooms);
    }



    public void  changeRoomAvailability( Long roomId) {
        roomService.updateRoomAvailability(roomId);

    }



}
