package edu.icet.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "OnlineBooking")

public class OnlineBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingIdOnl;
    private Long visitorIdOnl;
    private Long roomIdOnl;
    private LocalDate checkInDateOnl;
    private LocalDate checkOutDateOnl;


}
