package libApp;


import java.util.ArrayList;
import java.util.List;


public class BookList  {
    private ArrayList<Book> books = new ArrayList<Book>();
	public BookList() { //constructor
		Book b1 = new Book();
		b1.setName("Fellowship Point");
		b1.setAuthor("Alice Elliott Dark");
		Book b2 = new Book();
		b2.setName("Finding Me");
		b2.setAuthor("Viola Davis");
		Book b3 = new Book();
		b3.setName("Anna: The Biography");
		b3.setAuthor("Amy Odell");
		Book b4 = new Book();
		b4.setName("Cult Classic");
		b4.setAuthor("Sloane Crosley");
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
	} 

	public List<Book> getBooks()  {
		List<Book> res= new ArrayList<Book>();
		for (int i=0;i<books.size();i++) {
			res.add(books.get(i));
		}
		return res;
	}
	
	public void insertBook(Book b) {
		 books.add(b);
	}

	public List<Book> search(String keyword) {
		
		List<Book> res= new ArrayList<Book>();
		for (int i=0;i<books.size();i++) {
			if (books.get(i).getName().equals(keyword)){
				res.add(books.get(i));
				
			}
		}
		return res;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return books.size();
	}

	public Book get(int i) {
		if(i<books.size()) return books.get(i);
		return null;
	}
	
	public void remove(int i) {
		books.remove(i);
	}
	
}
