package itsphere.dev.bookswap.repository;

import itsphere.dev.bookswap.model.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"books"})
    Optional<User> findWithBooksById(Long id);
    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);

}
