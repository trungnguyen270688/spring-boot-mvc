package com.asiantech.application.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asiantech.application.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

	@Query(value="select book from BookEntity book order by book.id desc")
	List<BookEntity> searchAllBook(Pageable pageable);
	
	@Query(value="select count(book) from BookEntity book")
	Long countAllBook();

}
