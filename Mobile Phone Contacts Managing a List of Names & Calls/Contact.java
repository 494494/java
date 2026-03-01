public class Contact {
    // write code here
    private String name;
    private String phoneNumber;
    
    public Contact(String name,String phoneNumber){
        this.phoneNumber=phoneNumber;
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public static Contact createContact(String name,String phoneNumber){
        return new Contact(name,phoneNumber);
    }
}