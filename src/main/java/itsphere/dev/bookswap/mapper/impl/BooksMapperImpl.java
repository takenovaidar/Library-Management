package itsphere.dev.bookswap.mapper.impl;

import itsphere.dev.bookswap.mapper.BooksMapper;
import itsphere.dev.bookswap.model.domain.Books;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.BooksRequest;
import itsphere.dev.bookswap.model.dto.BooksResponse;
import org.springframework.stereotype.Component;

@Component
public class BooksMapperImpl implements BooksMapper {

    @Override
    public Books toBooks(BooksRequest request) {
        Books books = new Books();
        books.setTitle(request.getTitle());
        books.setAuthor(request.getAuthor());
        books.setGenre(request.getGenre());
        books.setState(request.getState());
        books.setCity(request.getCity());
        books.setCoverImageUrl(request.getCoverImageUrl());
        books.setCreatedAt(request.getCreatedAt());
        return books;
    }

    @Override
    public Books toBookWithUser(BooksRequest request) {
        Books books = toBooks(request);
        if(request.getUserId() != null) {
            User user = new User();
            user.setId(request.getUserId());
            books.setUser(user);
        }
        return books;
    }

    @Override
    public BooksResponse toResponse(Books books) {
        BooksResponse booksResponse = new BooksResponse();
        booksResponse.setTitle(books.getTitle());
        booksResponse.setAuthor(books.getAuthor());
        booksResponse.setGenre(books.getGenre());
        booksResponse.setState(books.getState());
        booksResponse.setCity(books.getCity());
        books.setCoverImageUrl(books.getCoverImageUrl());
        booksResponse.setCreatedAt(books.getCreatedAt());
        return booksResponse;
    }

    @Override
    public void updateBooks(BooksRequest request, Books books) {
        books.setTitle(request.getTitle());
        books.setAuthor(request.getAuthor());
        books.setGenre(request.getGenre());
        books.setState(request.getState());
        books.setCity(request.getCity());
        books.setCoverImageUrl(request.getCoverImageUrl());
        books.setCreatedAt(request.getCreatedAt());
    }
}
