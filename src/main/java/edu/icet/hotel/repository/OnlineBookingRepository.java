package edu.icet.hotel.repository;

import edu.icet.hotel.entity.OnlineBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineBookingRepository extends JpaRepository<OnlineBookingEntity, Long> {
}
