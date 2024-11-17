package edu.icet.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Visitor {

    private Long visitorId;
    private String fullName;
    private String gender;
    private String phoneNumber;
    private String emailAddress;
    private String homeAddress;
    private String nationality;
    private String idType;
    private String idNumber;
    private Integer numberOfGuests;
    private String paymentMethod;

}
