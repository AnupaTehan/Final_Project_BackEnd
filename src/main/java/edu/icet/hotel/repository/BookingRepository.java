package edu.icet.hotel.repository;

import edu.icet.hotel.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {






}
