package com.yuan.demo.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.demo.domain.Book;

public interface IBookService extends IService<Book> {
	
	Boolean saveBook(Book book);
    Boolean updateBook(Book book);
    Boolean deleteBook(Integer id);
    Book getBookById(Integer id);
    List<Book> getAllBook();
    IPage<Book> getBookPage(int currentPage, int pageSize, Map<String, String> paramsMap);
}
