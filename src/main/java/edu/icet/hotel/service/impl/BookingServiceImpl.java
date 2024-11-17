package edu.icet.hotel.service.impl;

import edu.icet.hotel.dto.Booking;
import edu.icet.hotel.entity.BookingEntity;
import edu.icet.hotel.repository.BookingRepository;
import edu.icet.hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    final ModelMapper modelMapper;

    @Override
    public void addNewBooking(Booking booking) {
        booking.setCheckInDate(LocalDate.now());
        bookingRepository.save(modelMapper.map(booking, BookingEntity.class));
    }

    @Override
    public List<Booking> getAllBooking() {
        List<Booking> booking = new ArrayList<>();

        bookingRepository.findAll().forEach(BookingEntity -> {
            booking.add(modelMapper.map(BookingEntity, Booking.class));
        });
        return booking;
    }
}
