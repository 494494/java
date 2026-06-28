import java.util.*;

public class Bank {
    // write code here
    
    private String name;
    private ArrayList<Branch> branches;
    
    public Bank(String name){
        this.name=name;
        branches=new ArrayList<Branch>();
    }
    
    public boolean addBranch(String name){
        if(findBranch(name)!=null){
            return false;
        }
        branches.add(new Branch(name));
        return true;
    }
    
    public boolean addCustomer(String branchName, String customerName,double tran){
        if(findBranch(branchName)==null){
           return false;
        }
         return findBranch(branchName).newCustomer(customerName,tran);
        
        
        
    }
    
    public boolean addCustomerTransaction(String branchName, String customerName, double anount){
        Branch branch= findBranch(branchName);
        if(branch !=null){
            return branch.addCustomerTransaction(customerName,anount);
        }
        return false;
    }
    
    
    private Branch findBranch(String name){
        
        for(var x: branches){
            if(x.getName().equals(name)){
                return x;
            }
        }
        return null;
    }
    
    
     public boolean listCustomers(String branchName, boolean showTransactions) {
        
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}








