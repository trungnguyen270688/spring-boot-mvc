package com.asiantech.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asiantech.application.domain.BookDomain;
import com.asiantech.application.service.BookService;

@Controller
public class BookController {

	private static Integer pageSize = 10;
	private static Integer numberOfPage = 4;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/book/page/{pageNumber}")
	public String showEmployeePage(@PathVariable int pageNumber, Model model) {
		int totalRow = bookService.countAllBook().intValue();
		int totalPage = 0;

		List<BookDomain> list = bookService.searchAllBook(pageSize, pageNumber);

		if (totalRow % pageSize != 0) {
			totalPage = totalRow / pageSize + 1;
		} else {
			totalPage = totalRow / pageSize;
		}

		//calculate the page will show on UI in paging section, maximum will show 5 pages.
		int currentPage = pageNumber;
		int begin = Math.max(1, currentPage + 2 > totalPage ? totalPage - numberOfPage : currentPage - 2);
		int end = Math.min(begin + numberOfPage, totalPage);

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("totalPageCount", totalPage);
		model.addAttribute("book", new BookDomain());

		model.addAttribute("list", list);
		return "booklist";
	}

	@RequestMapping(value = "/add-or-edit-book", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> addOrEditBook(@RequestBody BookDomain book) {
		try {
			BookDomain result = bookService.addOrEditBook(book);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/get-book/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getBook(@PathVariable Long id) {
		try {
			BookDomain result = bookService.findById(id);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delete-book", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> deleteBook(@RequestBody Long id) {
		try {
			bookService.deleteBook(id);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/detail")
	public String home(@RequestParam Long id, Model model) {
		BookDomain result = bookService.findById(id);
		model.addAttribute("book", result);
		return "detail";
	}
}
