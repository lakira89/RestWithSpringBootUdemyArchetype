#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.converter;

import ${package}.converter.mocks.MockBook;
import ${package}.data.model.Book;
import ${package}.data.vo.v1.BookVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DozerBookConverterTest {

    MockBook inputObject;

    @Before
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerConverter.parseObject(inputObject.mockEntity(), BookVO.class);
        Assert.assertEquals(Long.valueOf(0), output.getKey());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 1), output.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(0), output.getPrice());
        Assert.assertEquals("Title Test0", output.getTitle());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0), outputZero.getKey());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 1), outputZero.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(0), outputZero.getPrice());
        Assert.assertEquals("Title Test0", outputZero.getTitle());

        BookVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7), outputSeven.getKey());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 8), outputSeven.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(7), outputSeven.getPrice());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());

        BookVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12), outputTwelve.getKey());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 13), outputTwelve.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(12), outputTwelve.getPrice());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerConverter.parseObject(inputObject.mockVO(), Book.class);
        Assert.assertEquals(0L, output.getId());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 1), output.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(0), output.getPrice());
        Assert.assertEquals("Title Test0", output.getTitle());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);

        Assert.assertEquals(0L, outputZero.getId());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 1), outputZero.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(0), outputZero.getPrice());
        Assert.assertEquals("Title Test0", outputZero.getTitle());

        Book outputSeven = outputList.get(7);

        Assert.assertEquals(7L, outputSeven.getId());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 8), outputSeven.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(7), outputSeven.getPrice());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());

        Book outputTwelve = outputList.get(12);

        Assert.assertEquals(12L, outputTwelve.getId());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals(LocalDate.of(2021, 1, 13), outputTwelve.getLaunchDate());
        Assert.assertEquals(BigDecimal.valueOf(12), outputTwelve.getPrice());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
    }
}
