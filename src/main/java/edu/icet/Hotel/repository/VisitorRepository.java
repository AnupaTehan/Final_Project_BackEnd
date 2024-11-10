package edu.icet.Hotel.repository;

import edu.icet.Hotel.dto.Visitor;
import edu.icet.Hotel.entity.VisitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VisitorRepository extends JpaRepository<VisitorEntity,Long> {

    VisitorEntity findByfullName(String fullName);
}
