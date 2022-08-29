package libApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

public class Controller extends SelectorComposer<Component> {
 
    private static final long serialVersionUID = 1L;
     
    @Wire
    private Textbox keywordBox;
    @Wire
    private Listbox bookListbox;
    @Wire
    private Label bname;
    @Wire
    private Label author;
    @Wire
    private Textbox keywordBox2;
    @Wire
    private Listbox custListbox;
    @Wire
    private Label cname;
    @Wire
    private Label cbook;
    @Wire
    private Textbox keywordBox3;
    @Wire
    private Textbox keywordBox4;
    @Wire
    private Textbox keywordBox5;
    @Wire
    private Textbox keywordBox6;
    @Wire
    private Label breturn;
    
    private BookList books =  new BookList();
    private CustomerList cust =  new CustomerList();
    
  
    public  Controller() {
    	for (int i=0;i<cust.size();i++) { 
    		updateUsers(cust.getList().get(i).getName(),cust.getList().get(i).getBook().getName()); //load our list to maria db 
	  	}
    	
    	for (int i=0;i<books.size();i++) {
	  		  updateBooks(books.get(i).getName(),books.get(i).getAuthor()); //load our list to maria db 
	  	}
    	
    }
    
    @Listen("onClick = #lend")
    public void lend() {
    	String bname = keywordBox3.getValue();
    	String name = keywordBox4.getValue();
    	for (int i=0;i<cust.size();i++) {
    		if (cust.getList().get(i).getName().equals(name) && cust.getList().get(i).getBook().getName().equals("")) {
	    		for (int j=0;j<books.size();j++) {
	  	  		  	if (books.getBooks().get(j).getName().equals(bname)) {
	  	  		  		Book tmp= new Book();
	  	  		  	    tmp.setName(books.get(j).getName());
	  	  		  	    tmp.setAuthor(books.get(j).getAuthor());
	  	  		  		cust.getList().get(i).setBook(tmp);
	  	  		  	    addToDB(name,bname);
	  	  		  	}
	  	      	}
    		}
	    }
    }
     
    @Listen("onClick = #searchButton")
    public void search(){
        String keyword = keywordBox.getValue();
        List<Book> result =books.search(keyword);
        bookListbox.setModel(new ListModelList<Book>(result));
        for (int i=0;i<books.size();i++) {
	  		  if(i==0) {
	  			  bname=new Label(books.get(i).getName());
	  		      author=new Label(books.get(i).getAuthor());
	  		  }else {
		    	  bname.setValue(books.get(i).getName());
			  	  author.setValue(books.get(i).getAuthor());
	  		  }  
	      }
    }
     
    @Listen("onClick = #searchButton2")
    public void custSearch(){
        String keyword = keywordBox2.getValue();
        List<Customer> result =cust.csearch(keyword);
        custListbox.setModel(new ListModelList<Customer>(result));
        for (int i=0;i<books.size();i++) {
	  		  if(i==0) {
	  			  cname=new Label(cust.get(i).getName());
	  		      cbook=new Label(cust.getList().get(i).getBook().getName());
	  		  }else {
		    	  cname.setValue(cust.get(i).getName());
		    	  cbook.setValue(cust.getList().get(i).getBook().getName());
	  		  }  
	      }
    }
    
    @Listen("onClick = #breturn")
    public void breturn() {
    	String bname = keywordBox5.getValue();
    	String name = keywordBox6.getValue();
    	for (int i=0;i<cust.size();i++) {
    		if (cust.getList().get(i).getName().equals(name) && cust.getList().get(i).getBook().getName().equals(bname)) {
	    		books.getBooks().add(cust.getList().get(i).getBook());
	    		cust.getList().get(i).getBook().setName("");
	    		removefromDB(name,bname);
    		}
	    }
    }
    
    protected void removefromDB(String uname,String bname){
		Connection con;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url="jdbc:mariadb://localhost/library";
			String userName="root";
			String password="di#mar#sa";
			con=DriverManager.getConnection(url,userName,password);
			con=DriverManager.getConnection(url,userName,password);
			PreparedStatement s=con.prepareStatement("UPDATE customers SET book= ? WHERE name= ?");
			s.setString(1,"");
			s.setString(2,uname);
			s.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    protected void addToDB(String uname,String bname){
		Connection con;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url="jdbc:mariadb://localhost/library";
			String userName="root";
			String password="di#mar#sa";
			con=DriverManager.getConnection(url,userName,password);
			PreparedStatement s=con.prepareStatement("UPDATE customers SET book= ? WHERE name= ?");
			s.setString(1,bname);
			s.setString(2,uname);
			s.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    
    protected void updateBooks(String name,String aname){
		Connection con;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url="jdbc:mariadb://localhost/library";
			String userName="root";
			String password="di#mar#sa";
			con=DriverManager.getConnection(url,userName,password);
			Statement s=con.createStatement();
			String query="Insert into books "+ "(bname,author) " + "VALUES('" + name + "','" +
					aname + "')";
			s.executeQuery(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    protected void updateUsers(String uname,String bname){
		Connection con;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url="jdbc:mariadb://localhost/library";
			String userName="root";
			String password="di#mar#sa";
			con=DriverManager.getConnection(url,userName,password);
			Statement s=con.createStatement();
			String query="Insert into customers "+ "(name,book) " + "VALUES('" + uname + "','" +
					bname + "')";
			s.executeQuery(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
   
}