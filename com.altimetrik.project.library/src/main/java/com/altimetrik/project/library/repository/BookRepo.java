package com.altimetrik.project.library.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.altimetrik.project.library.entity.BookEntity;
import com.mysql.cj.Session;

@RepositoryRestResource
@Transactional
@Repository

public interface BookRepo extends JpaRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {


	BookEntity getByBookNameAndAuthor(String bookName, String author);
	
	
	
	@Query("from BookEntity where bookName like %?1%")
	List<BookEntity> findByBookName(String bookName);
	
	@Query("from BookEntity where author like %?1%")
	BookEntity findByAuthor(String author);
	
	@Query("from BookEntity where bookName like %?1% or author like %?1%")
	List<BookEntity> findByBookNameOrAuthor(String bookName,String author);
	
	@Query("from BookEntity where author like %?1% or bookName like %?1%")
	List<BookEntity> findByAuthorOrBookName(String author,String bookName);
	


}
