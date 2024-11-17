package edu.icet.hotel.service;

import edu.icet.hotel.dto.Receptionist;

public interface ReceptionistService {

    boolean validateCredentials(Receptionist receptionist);
}
