package org.gfg.JBDL6_DigitalLibrary.controller;

import org.gfg.JBDL6_DigitalLibrary.models.Book;
import org.gfg.JBDL6_DigitalLibrary.request.*;
import org.gfg.JBDL6_DigitalLibrary.response.BookResponse;
import org.gfg.JBDL6_DigitalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.CacheResponse;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/create/book")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookCreationRequest bookCreationRequest){
        // perform basic validation

        Book book = bookService.createBook(bookCreationRequest);

        BookResponse bookResponse = new BookResponse();
        if (book==null){
            bookResponse.setErrCode("002");
            bookResponse.setErrMessage("Book Not Inserted");
            return new ResponseEntity<>(bookResponse, HttpStatus.BAD_REQUEST);
        }

        bookResponse.setName(book.getName());

        return new ResponseEntity<>(bookResponse,HttpStatus.CREATED);
    }

}
