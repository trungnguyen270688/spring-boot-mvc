package com.asiantech.application.service;

import java.util.List;

import com.asiantech.application.domain.BookDomain;
import com.asiantech.application.entity.BookEntity;

public interface BookService {

	List<BookDomain> findAll();

	BookEntity save(BookEntity bookEntity);

	List<BookDomain> searchAllBook(int pageSize, int pageNumber);

	Long countAllBook();

	BookDomain addOrEditBook(BookDomain book) throws Exception;

	BookDomain findById(Long id);

	void deleteBook(Long id) throws Exception;

}
