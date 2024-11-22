package edu.icet.hotel.service;

import edu.icet.hotel.dto.OnlineVisitorLogin;



public interface OnlineVisitorLoginService {


    boolean validateCredentials(OnlineVisitorLogin onlineVisitorLogin);
}
