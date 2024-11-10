package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.Room;
import edu.icet.Hotel.entity.RoomEntity;
import edu.icet.Hotel.repository.RoomRepository;
import edu.icet.Hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class RoomServiceImpl implements RoomService {


    final ModelMapper modelMapper;

    private final RoomRepository roomRepository;

    @Override
    public void addNewRoom(Room room) {
        RoomEntity rooms = roomRepository.save(modelMapper.map(room, RoomEntity.class));
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        roomRepository.findAll().forEach(RoomEntity -> {
            rooms.add(modelMapper.map(RoomEntity, Room.class));
        });
        return rooms;
    }

    @Override
    public boolean updateRoomAvailability(Long roomId, String availability) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(roomId);
        if (roomEntity.isPresent()) {
            RoomEntity roomentity = roomEntity.get();
            roomentity.setAvailability(availability);
            roomRepository.save(roomentity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Room> getAvailableRooms() {
        List<RoomEntity> availableRooms = roomRepository.findByAvailability("available");
        List<Room> roomDtoList = new ArrayList<>();

        availableRooms.forEach(roomEntity -> {
            Room roomDto = modelMapper.map(roomEntity, Room.class);
            roomDtoList.add(roomDto);
        });

        return roomDtoList;
    }

}





