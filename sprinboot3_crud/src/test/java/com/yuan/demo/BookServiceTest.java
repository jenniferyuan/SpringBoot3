package com.yuan.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.demo.domain.Book;
import com.yuan.demo.service.IBookService;

@SpringBootTest
public class BookServiceTest {

	@Autowired
	private IBookService bookService;

	@Test
	void testGetById() {
		System.out.println(bookService.getBookById(4));
	}
	
	@Test
    void testGetAll(){
        bookService.getAllBook();
    }

	@Test
	void testSave() {
		Book book = new Book();
		book.setType("sc");
		book.setName("Science 16");
		book.setDescription("Science Description 16");
		bookService.saveBook(book);
	}
	
	@Test
    void testUpdate(){
        Book book = new Book();
        book.setId(16);
        book.setDescription("Updated Description 16");
        bookService.updateBook(book);
    }
	
	@Test
    void testDelete(){
        bookService.deleteBook(18);
    }
	
	@Test
    void testGetPage(){
        IPage<Book> page = bookService.getBookPage(2, 5, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
	
}
