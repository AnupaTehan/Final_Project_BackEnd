package edu.icet.hotel.service;

import edu.icet.hotel.dto.Room;

import java.util.List;

public interface RoomService {

    void addNewRoom(Room room);

    List<Room> getAllRooms();


    void updateRoomAvailability(Long roomId);

    List<Room> getAvailableRooms();
}
