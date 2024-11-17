package edu.icet.hotel.repository;

import edu.icet.hotel.entity.VisitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VisitorRepository extends JpaRepository<VisitorEntity,Long> {

    VisitorEntity findByfullName(String fullName);
}
