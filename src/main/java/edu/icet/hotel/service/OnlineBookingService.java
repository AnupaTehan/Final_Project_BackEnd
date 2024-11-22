package edu.icet.hotel.service;

import edu.icet.hotel.dto.OnlineBooking;

import java.util.List;

public interface OnlineBookingService {
    List<OnlineBooking> getOnlineBookings();

    void addNewOnlineBooking(OnlineBooking onlineBooking);
}
