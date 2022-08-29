package libApp;


import java.util.ArrayList;
import java.util.List;

public class CustomerList extends BookList {
	 private ArrayList<Customer> cust = new ArrayList<Customer>();
	 public CustomerList() { //constructor
		    Customer c1 = new Customer("Dimitris Sarantinos");
			Customer c2 = new Customer("Stratis Tsoukaris");
			Customer c3 = new Customer("Mixalis Fousfoukas");
			Customer c4 = new Customer("Nikos Skordias");
			cust.add(c1);
			cust.add(c2);
			cust.add(c3);
			cust.add(c4);
		} 
	 
	 public  ArrayList<Customer> getList(){
		 return cust;
	 }

	public List<Customer> csearch(String keyword) {
		List<Customer> res= new ArrayList<Customer>();
		for (int i=0;i<cust.size();i++) {
			if (cust.get(i).getName().equals(keyword)){
				res.add(cust.get(i));
			}
		}
		return res;
	}
}
