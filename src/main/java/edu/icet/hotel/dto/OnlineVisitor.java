package edu.icet.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class OnlineVisitor {

    private Long visitorIdOnl;
    private String fullNameOnl;
    private String genderOnl;
    private String phoneNumberOnl;
    private String emailAddressOnl;
    private String homeAddressOnl;
    private String nationalityOnl;
    private String idTypeOnl;
    private String idNumberOnl;
    private Integer numberOfGuestsOnl;
    private String paymentMethodOnl;


}
