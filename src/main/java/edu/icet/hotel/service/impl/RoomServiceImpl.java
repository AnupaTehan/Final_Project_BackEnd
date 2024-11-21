package edu.icet.hotel.service.impl;

import edu.icet.hotel.dto.Room;
import edu.icet.hotel.entity.RoomEntity;
import edu.icet.hotel.repository.RoomRepository;
import edu.icet.hotel.service.RoomService;
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
        room.setAvailability("available");
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
    public void updateRoomAvailability(Long roomId) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(roomId);
        if (roomEntity.isPresent()) {
            RoomEntity roomentity = roomEntity.get();
            roomentity.setAvailability("occupied");
            roomRepository.save(roomentity);
        } else {
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





