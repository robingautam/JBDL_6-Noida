package org.gfg.JBDL6_DigitalLibrary.service;

import org.gfg.JBDL6_DigitalLibrary.exception.BookAlreadyPresent;
import org.gfg.JBDL6_DigitalLibrary.models.Author;
import org.gfg.JBDL6_DigitalLibrary.models.Book;
import org.gfg.JBDL6_DigitalLibrary.repository.AuthorDao;
import org.gfg.JBDL6_DigitalLibrary.repository.BookDao;
import org.gfg.JBDL6_DigitalLibrary.request.BookCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    public Book createBook(BookCreationRequest bookCreationRequest){

        String bookId = bookCreationRequest.getBookId();
        String bookName = bookCreationRequest.getBookName();
        String bookType = bookCreationRequest.getBookType().toString();
        String authorEmail = bookCreationRequest.getAuthorEmail();

        Book bookResult = null;

        try {
            int status = bookDao.findBookById(bookId);
            if (status > 0) {
                throw new BookAlreadyPresent("Book is Already present in the database");
            }

            int result = bookDao.createBookInDatabase(bookId,bookName, bookType, authorEmail);
            if (result<=0){
                return null;
            }

            boolean isAuthorExist = false;

            try {
                Author authorExist = authorDao.findAuthorById(authorEmail);
                isAuthorExist = true;
            }
            catch (Exception exception){
                isAuthorExist = false;
            }

            if (isAuthorExist==true){
                return bookResult;
            }

            authorDao.createAuthor(BookCreationRequest.toAuthor(bookCreationRequest));


        }
        catch (BookAlreadyPresent e){
            throw new RuntimeException(e);
        }
        return bookResult;
    }
}
