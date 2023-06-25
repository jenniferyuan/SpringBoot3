package com.yuan.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.demo.domain.Book;

@Mapper
public interface BookDao extends BaseMapper<Book>{

}
