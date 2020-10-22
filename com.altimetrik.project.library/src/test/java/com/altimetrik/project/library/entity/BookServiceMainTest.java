package com.altimetrik.project.library.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import com.altimetrik.project.library.repository.BookRepo;
import com.altimetrik.project.library.service.BookServiceMain;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceMainTest {
	
	 @MockBean
	 private BookRepo repo;	 
	 
	 @Autowired
	 private BookServiceMain service;
	 
	 @Before
	 public void setup()
	 {
		 MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void testSaveBook() {
		BookEntity en=new BookEntity(99, "Paradox", "Ken", "The Book of Mystery");
		when(repo.save(en)).thenReturn(en);	
		assertEquals(en, service.saveBook(en));
	}
	
	@Test
	public void testGetAllUser() {
		when(repo.findAll()).thenReturn(Stream.of(new BookEntity(99, "Paradox", "Ken", "The Book of Mystery"),new BookEntity(93, "Change", "Pen", "The Book of Change")).collect(Collectors.toList()));
		assertEquals(2, service.getBooks().size());
	}
	
	@Test
	public void testDeleteUser() {
		BookEntity en=new BookEntity(99, "Paradox", "Ken", "The Book of Mystery");
		repo.delete(en);
		verify(repo, times(1)).delete(en);
	}
	
/*	@Test
	public void testUpdateUser() {
		BookEntity en=new BookEntity(99, "Paradox", "Ken", "The Book of Mystery");
		repo.save(en);
		BookEntity newEntity=repo.findByAuthor("Ken");
		newEntity.setBookName("Gold");
		repo.save(newEntity);
		assertThat(newEntity.getAuthor()).isEqualTo("Gold");
	}*/
	
	
	

}
