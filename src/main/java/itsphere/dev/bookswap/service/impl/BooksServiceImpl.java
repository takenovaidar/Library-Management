package itsphere.dev.bookswap.service.impl;

import itsphere.dev.bookswap.mapper.BooksMapper;
import itsphere.dev.bookswap.model.domain.Books;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.BooksRequest;
import itsphere.dev.bookswap.model.dto.BooksResponse;
import itsphere.dev.bookswap.repository.BooksRepository;
import itsphere.dev.bookswap.repository.UserRepository;
import itsphere.dev.bookswap.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {
    private final BooksMapper booksMapper;
    private final BooksRepository booksRepository;
    private final UserRepository userRepository;


    @Override
    public String createBooks(BooksRequest booksRequest) {
        User user = userRepository.findById(booksRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + booksRequest.getUserId()));

        Books books = booksMapper.toBookWithUser(booksRequest);
        books.setUser(user);
        books.setCoverImageUrl(booksRequest.getCoverImageUrl());
        booksRepository.save(books);
        return "Book created successfully!";
    }

    @Override
    public List<BooksResponse> getAllBooks() {
        return booksRepository.findAll().stream()
                .map(booksMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Long id) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found!"));
        booksRepository.delete(books);
    }

    @Override
    public void updateBook(Long id, BooksRequest booksRequest) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        booksMapper.updateBooks(booksRequest, books);
        books.setCoverImageUrl(booksRequest.getCoverImageUrl());
        booksRepository.save(books);
    }

}
