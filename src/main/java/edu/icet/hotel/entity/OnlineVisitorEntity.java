package edu.icet.hotel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "OnlineVisitor")


public class OnlineVisitorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
