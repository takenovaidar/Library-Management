package itsphere.dev.bookswap.repository;

import itsphere.dev.bookswap.model.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
