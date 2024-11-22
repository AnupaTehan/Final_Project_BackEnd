package edu.icet.hotel.service;

import edu.icet.hotel.dto.OnlineVisitor;

import java.util.List;
import java.util.Optional;

public interface OnlineVisitorService {

    void registerNewOnlineVisitor(OnlineVisitor onlineVisitor);

    List<OnlineVisitor> getOnlineVisitors();

    Optional<OnlineVisitor> searchOnlineVisitor(String fullNameOnl);
}
