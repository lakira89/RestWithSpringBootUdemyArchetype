#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.converter.mocks;

import ${package}.data.model.Book;
import ${package}.data.model.Person;
import ${package}.data.vo.v1.BookVO;
import ${package}.data.vo.v1.PersonVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }

    private Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setAuthor("Author Test" + number);
        book.setLaunchDate(LocalDate.of(2021, 1, 1 + number));
        book.setPrice(BigDecimal.valueOf(number));
        book.setTitle("Title Test" + number);
        return book;
    }

    private BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setKey(number.longValue());
        book.setAuthor("Author Test" + number);
        book.setLaunchDate(LocalDate.of(2021, 1, 1 + number));
        book.setPrice(BigDecimal.valueOf(number));
        book.setTitle("Title Test" + number);
        return book;
    }
}
