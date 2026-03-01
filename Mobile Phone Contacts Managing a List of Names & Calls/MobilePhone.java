import java.util.ArrayList;
public class MobilePhone {
    // write code here
    private String myNumber;
    private ArrayList <Contact> myContacts;
    
    public MobilePhone(String myNumber){
        this.myNumber=myNumber;
        this.myContacts=new ArrayList<Contact>();
    }
    
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>=0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
        
    }
    
//find Contact
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String ContactName){
        for(int i=0;i<this.myContacts.size();i++){
            Contact contact=this.myContacts.get(i);
            if(contact.getName().equals(ContactName)){
                return i;
            }
        }
        return -1;
    }
    
     public boolean updateContact(Contact oldContact, Contact newContact) {
        
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() +
                " already exists.  Update was not successful.");
            return false;
        }
 
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }
    public boolean removeContact(Contact contact){
        int i=findContact(contact);
        if(i >=0){
            this.myContacts.remove(i);
            return true;
        }
        return false;
    }
    public Contact queryContact(String name){
        int i=findContact(name);
        if(i>=0){
            return this.myContacts.get(i);
        }
        return null;
    }
    public void printContacts(){
        System.out.println("Contact List:");
        int i=1;
        for(Contact x: myContacts){
            System.out.println(i+". "+x.getName()+" -> "+
            x.getPhoneNumber());
            i++;
        }
    }
}