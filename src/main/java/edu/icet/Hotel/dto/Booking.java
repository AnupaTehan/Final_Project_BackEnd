package edu.icet.Hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking {

    private Long bookingId;
    private Long visitorId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
