package itsphere.dev.bookswap.repository;

import itsphere.dev.bookswap.model.domain.Messege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessegeRepository extends JpaRepository<Messege, Long> {
    List<Messege> findBySenderIdAndRecipientId(Long senderId, Long recipientId);
}

