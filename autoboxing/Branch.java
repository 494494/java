import java.util.*;
public class Branch {
    // write code here
    private String name;
    
    private ArrayList<Customer> customers;
    
    public Branch(String name){
        this.name=name;
        customers=new ArrayList<Customer>();
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
    public boolean newCustomer(String name, double intAmount){
        if(findCustomer(name)==null){
            customers.add(new Customer(name,intAmount));
            return true;
        }
        return false;
    }
    
    private Customer findCustomer(String name){
        for(var x: customers){
            if(x.getName().equals(name)){
                return x;
            }
        }
        return null;
    }
    
    public boolean addCustomerTransaction(String customerName, double amount) {
        
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }
}
