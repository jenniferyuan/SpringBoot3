package com.yuan.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.demo.domain.Book;
import com.yuan.demo.service.IBookService;
import com.yuan.demo.vo.Response;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private IBookService bookService;

	@GetMapping
	public Response getAll() {
		List<Book> bookList = bookService.list();
		if (bookList != null) {
			return new Response(Boolean.TRUE, bookList, Response.SUCCESS);
		}
		return new Response(Boolean.FALSE, Response.FAILED);
	}

	@PostMapping
	public Response save(@RequestBody Book book) {
		Boolean flag = bookService.save(book);
		if (flag) {
			return new Response(flag, Response.SUCCESS);
		}
		return new Response(flag, Response.FAILED);
	}

	@PutMapping
	public Response update(@RequestBody Book book) {
		Boolean flag = bookService.updateBook(book);
		if (flag) {
			return new Response(flag, Response.SUCCESS);
		}
		return new Response(flag, Response.FAILED);
	}

	@DeleteMapping("{id}")
	public Response delete(@PathVariable Integer id) {
		Boolean flag = bookService.deleteBook(id);
		if (flag) {
			return new Response(flag, Response.SUCCESS);
		}
		return new Response(flag, Response.FAILED);
	}

	@GetMapping("{id}")
	public Response getById(@PathVariable Integer id) {
		Book book = bookService.getById(id);
		if (!ObjectUtils.isEmpty(book)) {
			return new Response(Boolean.TRUE, book, Response.SUCCESS);
		}
		return new Response(Boolean.FALSE, Response.FAILED);
	}

	@GetMapping("{currentPage}/{pageSize}")
	public Response getPage(@PathVariable int currentPage, @PathVariable int pageSize, @RequestParam(required=false) Map<String,String> paramsMap) {
		IPage<Book> bookPage = bookService.getBookPage(currentPage, pageSize, paramsMap);
		if (!ObjectUtils.isEmpty(bookPage)) {
			return new Response(Boolean.TRUE, bookPage, Response.SUCCESS);
		}
		return new Response(Boolean.FALSE, Response.FAILED);
	}

}
