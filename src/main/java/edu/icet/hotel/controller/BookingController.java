package edu.icet.hotel.controller;

import edu.icet.hotel.dto.Booking;
import edu.icet.hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/booking")

public class BookingController {


    private final RoomController roomController;


    private  final BookingService bookingService;

    @PostMapping("/addNewBooking")
    public boolean addNewBooking(@RequestBody Booking booking){
        if (booking == null) {
            return false;
        }
        bookingService.addNewBooking(booking);

        roomController.changeRoomAvailability(booking.getRoomId());

        return  true;




    }


    @GetMapping("/getAll-room")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }








}
