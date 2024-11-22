package edu.icet.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OnlineBooking {

    private Long bookingIdOnl;
    private Long visitorIdOnl;
    private Long roomIdOnl;
    private LocalDate checkInDateOnl;
    private LocalDate checkOutDateOnl;
}
