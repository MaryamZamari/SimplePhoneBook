package com.javaSe.phonebook.service;

import com.javaSe.phonebook.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Phonebook {
    private List<Contact> contactList;
    public Phonebook(List<Contact> contacts){
        this.contactList= contacts;
    }
    public Phonebook(){}
    public List<Contact> getContactList(){return this.contactList;}
    public void setContactList(int id , Contact contact) {
        Optional<Contact> c = Optional.ofNullable(this.contactList.get(id));
        if (c.isPresent()) {
            this.contactList.set(id, contact);
        } else {
            System.out.println("the contact does not exist. try a valid id!");
        }
    }

    public void removeContact(int id){
        Optional<Contact> contact= Optional.ofNullable(this.contactList.get(id));
        if(contact.isPresent()){
            this.contactList.remove(contact);
            System.out.println("contact has been removed!");
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
