package edu.icet.Hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room {

    private Long roomId;
    private String typeOfRoom;
    private String bedType;
    private String amenities;
    private Double pricePerNight;
    private String availability;

}


