package itsphere.dev.bookswap.controller;

import itsphere.dev.bookswap.model.dto.BooksRequest;
import itsphere.dev.bookswap.model.dto.BooksResponse;
import itsphere.dev.bookswap.service.BooksService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    // Создание новой книги
    @PostMapping("/create")
    public ResponseEntity<String> createBook(@Valid @RequestBody BooksRequest booksRequest) {
        String response = booksService.createBooks(booksRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Получение всех книг
    @GetMapping("/get")
    public ResponseEntity<List<BooksResponse>> getAllBooks() {
        List<BooksResponse> books = booksService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Обновление книги по ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BooksRequest booksRequest) {
        booksService.updateBook(id, booksRequest);
        return new ResponseEntity<>("Book with id " + id + " successfully updated!", HttpStatus.OK);
    }

    // Удаление книги по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
        return new ResponseEntity<>("Book with id " + id + " successfully deleted!", HttpStatus.OK);
    }
}

