package edu.icet.hotel.repository;

import edu.icet.hotel.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
    List<RoomEntity> findByAvailability(String available);
}
