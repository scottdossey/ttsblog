package com.techtalentsouth.techtalentblog.blogpost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Except we want to persist this class in the database...

@Entity //We are going to store the object persistently use the Java Persistence API
        //(JPA). In our project we've configured the JPA to store to an H2 database.
public class BlogPost {	
	
	//In order to use this field as primary key in the database, we need to add an 
	//annotation marking it as the primary key
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //Primary key
	
	private String title;
	private String author;
	private String blogEntry;
	
	public BlogPost() {
		//JPA requires no argument constructor. If you don't include an empty constructor
		//you will run into problems down the line when you try to create insert or read
		//from the BlogPostRepository.....
	}
		
	public BlogPost(String title, String author, String blogEntry) {
		this.title=title;
		this.author=author;
		this.blogEntry=blogEntry;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBlogEntry() {
		return blogEntry;
	}

	public void setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
	}
}
