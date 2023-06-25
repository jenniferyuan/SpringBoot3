package com.yuan.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.demo.domain.Book;
import com.yuan.demo.mapper.BookDao;
import com.yuan.demo.service.IBookService;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public Boolean saveBook(Book book) {
		return bookDao.insert(book) > 0;
	}

	@Override
	public Boolean updateBook(Book book) {
		return bookDao.updateById(book) > 0;
	}

	@Override
	public Boolean deleteBook(Integer id) {
		return bookDao.deleteById(id) > 0;
	}

	@Override
	public Book getBookById(Integer id) {
		return bookDao.selectById(id);
	}

	@Override
	public List<Book> getAllBook() {
		return bookDao.selectList(null);
	}

	@Override
	public IPage<Book> getBookPage(int currentPage, int pageSize, Map<String, String> paramsMap) {
		IPage<Book> page = new Page<>(currentPage, pageSize);
		if (MapUtils.isNotEmpty(paramsMap)) {
			
			//way1
			LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//			   lambdaQueryWrapper.like(paramsMap.get("type")!=null, Book::getType, paramsMap.get("type"));
//			   lambdaQueryWrapper.like(paramsMap.get("name")!=null, Book::getName, paramsMap.get("name"));
//			   lambdaQueryWrapper.like(paramsMap.get("description")!=null, Book::getDescription, paramsMap.get("description"));
			
			//way2
			QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
			paramsMap.forEach((k, v) -> {
				queryWrapper.like(StringUtils.isNotBlank(k), k, v);
			});

			bookDao.selectPage(page, queryWrapper);
		} else {
			bookDao.selectPage(page, null);
		}

		return page;
	}

}
