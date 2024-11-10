package edu.icet.Hotel.entity;

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
@Table(name = "Receptionist")
public class ReceptionistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receptionistId;
    private String username;
    private String password;

}
