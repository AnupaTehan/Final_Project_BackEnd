package edu.icet.hotel.service.impl;

import edu.icet.hotel.dto.OnlineBooking;
import edu.icet.hotel.entity.OnlineBookingEntity;
import edu.icet.hotel.repository.OnlineBookingRepository;
import edu.icet.hotel.service.OnlineBookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class OnlineBookingServiceImpl   implements OnlineBookingService {

    final OnlineBookingRepository onlineBookingRepository;

    final ModelMapper modelMapper;




    @Override
    public List<OnlineBooking> getOnlineBookings() {
        List<OnlineBooking> bookings = new ArrayList<>();
        onlineBookingRepository.findAll().forEach(OnlineBookingEntity->{
            bookings.add(modelMapper.map(OnlineBookingEntity, OnlineBooking.class));
        });
        return bookings;
    }

    @Override
    public void addNewOnlineBooking(OnlineBooking onlineBooking) {
        OnlineBookingEntity onlineBookingEntity = modelMapper.map(onlineBooking, OnlineBookingEntity.class);
        onlineBookingRepository.save(onlineBookingEntity);
    }
}
