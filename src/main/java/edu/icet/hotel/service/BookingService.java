package edu.icet.hotel.service;

import edu.icet.hotel.dto.Booking;

import java.util.List;

public interface BookingService {
    void addNewBooking(Booking booking);

    List<Booking> getAllBooking();
}
