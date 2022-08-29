package libApp;

import java.io.Serializable;


public class Book implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String name; //users first name
	private String author; //users last name
	
	public Book() {} //constructor
	
	public Book(String name,String author) { //PROPER constructor CREATE
		this.name=name;
		this.author=author;
	}
	
	public String getName() {  //READ
		return name;
	}
	
	public void setName(String name) { //UPDATE
		this.name = name;
	}
	
	public String getAuthor() { //READ
		return author;
	}
	
	public void setAuthor(String author) { //UPDATE
		this.author = author;
	}
	
	public void delete() { //delete
		this.delete();
	}

}