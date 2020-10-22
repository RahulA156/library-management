package com.altimetrik.project.library.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.altimetrik.project.library.entity.BookEntity;
import com.altimetrik.project.library.exception.ResourceNotFoundException;
import com.altimetrik.project.library.service.BookServiceMain;
import com.sipios.springsearch.anotation.SearchSpec;



@RestController
@RequestMapping("/books")
public class BookControllerMain {
	
	@Autowired
	private BookServiceMain bookService;
	
	@RequestMapping(method = RequestMethod.POST,path = "")
	public ResponseEntity<Object> addBook(@RequestBody @Valid BookEntity book) {
		
		BookEntity savedBook= bookService.saveBook(book);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "/list-of-books")
	public  List<BookEntity> addAllBooks(@RequestBody @Valid  @NotEmpty(message = "Input Field cannot be empty.") List<BookEntity> books ) {
		return bookService.saveAllBooks(books);
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/show-all")
	public List<BookEntity> findAllBooks()
	{
		return bookService.getBooks();
	}
	
	
	/*@RequestMapping(method = RequestMethod.GET)
	public List<BookEntity> getBookByAuthor(@RequestParam String bookName)
	{	
		return bookService.getBookByName(bookName);
	} */
	
	@RequestMapping(method = RequestMethod.GET)
	public List<BookEntity> fetchBookByBookNameOrAuthor(@RequestParam String bookName,@RequestParam String author)
	{	
		return bookService.searchBookByNameAndAuthor(bookName, author);
	} 
		
	
	@RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
	 public String deleteProduct(@PathVariable int id) {
         bookService.deleteBook(id);
         return ("Book Deleted Successfully");
    }
	
	@RequestMapping(method = RequestMethod.PUT,path = "/update")
    public BookEntity updateProduct(@RequestBody BookEntity bookEntity) {
        return bookService.updateBook(bookEntity);
    }

}
