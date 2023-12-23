package com.javaSe.phonebook.service;
import com.javaSe.phonebook.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private int id;
    private static int idCounter= 0;
    private List<Contact> contactList;
    public Phonebook(int id, List<Contact> contacts){
        this.id= id;
        this.contactList= contacts;
    }

    public Phonebook(List<Contact> contacts){
        this.id= generateUniqueId();
        this.contactList= contacts;
    }
    public Phonebook(){}
    public List<Contact> getContactList(){return this.contactList;}
    public void setContactList(int id , Contact contact) {
        Contact c = this.contactList.get(id);
        if (c != null) {
            this.contactList.set(id, contact);
        } else {
            System.out.println("the contact does not exist. try a valid id!");
        }
    }

    private static int generateUniqueId(){
        return idCounter++;
    }

    public Contact getContactById(int id){
        return contactList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void removeContact(int id){
        Contact contact= getContactById(id);
        if(contact != null){
            this.contactList.remove(contact);
            System.out.println("contact has been removed! updated list : " + this.getContactList());
        }else{
            System.out.println("the contact does not exist! try a valid id!");
        }
    }

    public void printAllContacts() {
        if(!contactList.isEmpty()){
            System.out.println("here are all the registered contacts up until now: ");
            contactList.stream().forEach(System.out :: println);
            }
        else{
            System.out.println("There are no contacts registered yet. proceed to register some!");
        }
    }
    public void addContact(Contact newContact) {
        if(this.contactList == null){
            this.contactList= new ArrayList<>();
        }
        this.contactList.add(newContact);
        System.out.println(
                "your designated ID is "
                 + newContact.getId()
                 + " ,your name is registered as "
                 + newContact.getName()
                 + " and the associated numbers are "
                 + newContact.getNumbers().toString());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "contactList=" + contactList +
                '}';
    }
}
//TODO: TESTING
