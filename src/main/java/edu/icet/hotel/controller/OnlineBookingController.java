package edu.icet.hotel.controller;

import edu.icet.hotel.dto.OnlineBooking;
import edu.icet.hotel.service.OnlineBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/online-booking")

public class OnlineBookingController {

    final OnlineBookingService onlineBookingService;
    final RoomController roomController;

    @GetMapping("/getAll-online-bookings")
    public List<OnlineBooking> getAllOnlineBookings() {
        return onlineBookingService.getOnlineBookings();
    }

    @PostMapping("/addNew-online-booking")
    public boolean addNewOnlineBooking(@RequestBody OnlineBooking onlineBooking ) {
        if (onlineBooking != null) {
            onlineBookingService.addNewOnlineBooking(onlineBooking);
            roomController.changeRoomAvailability(onlineBooking.getRoomIdOnl());
            return true;
        } else {
            return false;
        }
    }



}
