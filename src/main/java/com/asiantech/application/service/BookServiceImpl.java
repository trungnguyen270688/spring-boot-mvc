package com.asiantech.application.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.asiantech.application.domain.BookDomain;
import com.asiantech.application.entity.BookEntity;
import com.asiantech.application.repository.BookRepository;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookDomain> findAll() {
		List<BookEntity> listEntity = bookRepository.findAll();
		return listEntity.stream().map(x -> x.toDomain()).collect(Collectors.toList());
	}

	@Override
	public BookEntity save(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}

	@Override
	public List<BookDomain> searchAllBook(int pageSize, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber < 1 ? 0 :pageNumber -1, pageSize);
		List<BookEntity> listEntity = bookRepository.searchAllBook(pageable);
		return listEntity.stream().map(x -> x.toDomain()).collect(Collectors.toList());
	}
	
	@Override
	public Long countAllBook() {
		return bookRepository.countAllBook();
	}

	@Override
	public BookDomain addOrEditBook(BookDomain book) throws Exception {
		BookEntity data = null;
		if (book.getId() != null ) {
			
			BookEntity bookUpdate = bookRepository.findById(book.getId()).orElse(null);
			
			if (bookUpdate == null) {
				throw new Exception("Book does not exist!");
			} else {
				bookUpdate.setTitle(book.getTitle());
				bookUpdate.setDescription(book.getDescription());
				bookUpdate.setAuthor(book.getAuthor());
				bookUpdate.setUpdatedDate(new Date());
				data = bookUpdate;
			}
			
		} else {
			data = book.toEntity();
		}
		
		data = bookRepository.save(data);
		
		return data.toDomain();
	}

	@Override
	public BookDomain findById(Long id) {
		BookEntity data = bookRepository.findById(id).orElse(new BookEntity());
		return data.toDomain();
	}

	@Override
	public void deleteBook(Long id) throws Exception {
		
		BookEntity data = bookRepository.findById(id).orElse(null);
		
		if (data == null) {
			throw new Exception("Book does not exist!");
		} else {
			bookRepository.delete(data);
		}
	}


}
