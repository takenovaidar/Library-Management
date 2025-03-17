package itsphere.dev.bookswap.repository;

import itsphere.dev.bookswap.model.domain.Swap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwapRepository extends JpaRepository<Swap, Long> {
}
