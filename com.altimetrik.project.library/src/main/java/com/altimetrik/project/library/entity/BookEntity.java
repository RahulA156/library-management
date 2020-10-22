package com.altimetrik.project.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "BOOK_TBL")
public class BookEntity {
	//public BookEntity(String)
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	private int id;
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", description=" + description
				+ ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getBookName()=" + getBookName()
				+ ", getAuthor()=" + getAuthor() + ", getDescription()=" + getDescription() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotEmpty(message = "Book name not given")
	private String bookName;
	@NotEmpty(message = "Author not given")
	private String author;
	@NotEmpty(message = "Description not given")
	private String description;
	public BookEntity(int id, @NotEmpty(message = "Book name not given") String bookName,
			@NotEmpty(message = "Author not given") String author,
			@NotEmpty(message = "Description not given") String description) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.description = description;
	}
	
	
	
}
