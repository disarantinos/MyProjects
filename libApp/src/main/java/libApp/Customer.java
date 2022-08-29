package libApp;

import java.io.Serializable;


public class Customer implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String name; //users full name
	private Book book; //users book
	
	public Customer() {} //constructor
	
	public Customer(String name) { // constructor for user with out book CREATE
		this.name=name;
		book=new Book("","");
	}
	
	public Customer(String name,Book book) { // constructor for lenderCREATE
		this.name=name;
		this.book=new Book(book.getName(),book.getAuthor());
	}
	
	
	public Book getBook() {  //READ
		return book;
	}
	

	public String getName() {  //READ
		return name;
	}
	
	
	public void setname(String fName) { //UPDATE
		this.name = fName;
	}
	
	public void setBook(Book book) {
		this.book=book;
	}
	
	public void delete() { //delete
		this.delete();
	}
	
	public void returnBook() {
		book=new Book("","");
	}
	
}
