package edu.icet.hotel.repository;

import edu.icet.hotel.entity.OnlineVisitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OnlineVisitorRepository extends JpaRepository<OnlineVisitorEntity, Long> {

    OnlineVisitorEntity findByfullNameOnl(String fullNameOnl);

    Optional<OnlineVisitorEntity> findByEmailAddressOnlAndIdNumberOnl(String emailAddressOnl, String idNumberOnl); // Correct the return type
}
