package edu.icet.Hotel.repository;

import edu.icet.Hotel.entity.ReceptionistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ReceptionistRepository extends JpaRepository<ReceptionistEntity, Long> {

    Optional<ReceptionistEntity> findByUsernameAndPassword(String username, String password);

}
