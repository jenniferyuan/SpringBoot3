package com.yuan.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.demo.domain.Book;
import com.yuan.demo.mapper.BookDao;

@SpringBootTest
public class BookDaoTest {
	
	@Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }
    
    @Test
    void testSave(){
        Book book = new Book();
        //book.setId(1);
        book.setType("his");
        book.setName("History name2");
        book.setDescription("History description2");
        bookDao.insert(book);
    }
    
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(13);
        book.setDescription("Updated");
        bookDao.updateById(book);
    }
    
    @Test
    void testDelete(){
//    	QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//    	queryWrapper.eq("type", "sc");
//      bookDao.delete(queryWrapper);
    	bookDao.deleteById(1);
    }
    
    @Test
    void testGetAll(){
        List<Book> selectList = bookDao.selectList(null);
    }
    
    
    //Need MybatisPlusInterceptor Configuration
    @Test
    void testGetPage(){
    	IPage<Book> page = new Page<>(2, 5);
    	bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());		//current page
        System.out.println(page.getSize());			//page records size
        System.out.println(page.getTotal());		//all records size
        System.out.println(page.getPages());		//all pages amount
        System.out.println(page.getRecords());		//single page records detail
    }
    
    @Test
    void testGetByQueryWrapper(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Java");
        bookDao.selectList(qw);
    }
    
    
    @Test
    void testGetByLambdaQueryWrapper1(){
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Book::getName, "Java");
        bookDao.selectList(lqw);
    }
    
    @Test
    void testGetByLambdaQueryWrapper2(){
    	String bookName = "Java";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(bookName!=null, Book::getName, bookName);
        bookDao.selectList(lqw);
    }
    
    
    
    
    

}
