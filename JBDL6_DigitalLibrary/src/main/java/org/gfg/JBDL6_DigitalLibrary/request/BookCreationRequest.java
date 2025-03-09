package org.gfg.JBDL6_DigitalLibrary.request;


import lombok.*;
import org.gfg.JBDL6_DigitalLibrary.models.Author;
import org.gfg.JBDL6_DigitalLibrary.models.BookType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreationRequest {

    String bookId;
    String bookName;
    BookType bookType;
    String authorName;
    String authorEmail;
    String authorNumber;


    public static Author toAuthor(BookCreationRequest request){
        Author author = Author.builder().authorEmail(request.getAuthorEmail())
                .authorName(request.getAuthorName()).phoneNo(request.getAuthorNumber()).build();
        return author;
    }

}
