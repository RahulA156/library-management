package com.altimetrik.project.library.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.View;

import org.apache.ibatis.javassist.NotFoundException;
import org.hibernate.annotations.AnyMetaDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.altimetrik.project.library.entity.BookEntity;
import com.altimetrik.project.library.exception.ResourceNotFoundException;
import com.altimetrik.project.library.repository.BookRepo;
import com.sipios.springsearch.anotation.SearchSpec;

@Service
public class BookServiceMain{

	@Autowired
	private BookRepo bookRepository;
	
	public BookEntity saveBook(BookEntity book) {		
		return bookRepository.save(book);		
	}
	
	public List<BookEntity> saveAllBooks(List<BookEntity> books)
	{
		return (List<BookEntity>) bookRepository.saveAll(books);
	}
	
	public List<BookEntity> getBooks() {
		return (List<BookEntity>) bookRepository.findAll();
		
	}
	
	public BookEntity getBookById(int id)
	{
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with This ID :" + id));
		
	}
	
	public List<BookEntity> getBookByName(String bookName)
	{
		return bookRepository.findByBookName(bookName);
		
	}
	
	
	
	
	 public List<BookEntity> searchBookByNameAndAuthor(String bookName,String author) 
	 { 	
		 List<BookEntity> en=new ArrayList<BookEntity>();
		if(author.trim()==null || author.isBlank()) 
		{
		en= bookRepository.findByBookNameOrAuthor(bookName,null);
		}
		else if(bookName.trim()==null || bookName.isBlank()) 
		{
			en= bookRepository.findByBookNameOrAuthor(author,null);
		}
		else if(bookName != null && author != null)
		{
		en= bookRepository.findByBookNameOrAuthor(bookName, author);
		}
		return en;
	 }
	 
	
	
	public ResponseEntity<?> deleteBook(int id) {
		 return bookRepository.findById(id)
			        .map(book -> {
			            bookRepository.delete(book);
			            return new ResponseEntity(HttpStatus.NO_CONTENT);
			         })
			         .orElseThrow(() -> new ResourceNotFoundException("Book not found with This ID :" +id));
    }
	
	
	public BookEntity updateBook(BookEntity bookEntity)
	{
		BookEntity existingBook=bookRepository.findById(bookEntity.getId()).orElseThrow(() -> new ResourceNotFoundException("Book not found with This ID :" ));
		existingBook.setBookName(bookEntity.getBookName());
		existingBook.setAuthor(bookEntity.getAuthor());
		existingBook.setDescription(bookEntity.getDescription());
		return bookRepository.save(existingBook);
		
	}

	
	
	

	
	
}
