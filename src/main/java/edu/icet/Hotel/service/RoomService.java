package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.Room;

import java.util.List;

public interface RoomService {

    void addNewRoom(Room room);

    List<Room> getAllRooms();


    boolean updateRoomAvailability(Long roomId, String availability);

    List<Room> getAvailableRooms();
}
