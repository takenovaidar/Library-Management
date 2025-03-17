package itsphere.dev.bookswap.service;

import itsphere.dev.bookswap.model.dto.BooksRequest;
import itsphere.dev.bookswap.model.dto.BooksResponse;

import java.util.List;


public interface BooksService {
    String createBooks(BooksRequest booksRequest);
    List<BooksResponse> getAllBooks();
    void deleteBook(Long id);
    void updateBook(Long id, BooksRequest booksRequest);
}
