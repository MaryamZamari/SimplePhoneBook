package com.javaSe.phonebook.model;

import java.util.HashMap;
import java.util.Map;

public class ContactNumber {
    private int id;
    private String number;
    private ContactType type;
    private static int idCounter= 1;

    public ContactNumber(int id, String number, ContactType type) {
        this.id= generateUniqueId();
        this.number = number;
        this.type= type;
        System.out.println(this.id + " has been assigned to " + this.number + " as Number ID");
    }

    private int generateUniqueId() {
        return idCounter++;
    }

    public ContactNumber(String number, ContactType type) {
        this.id= generateUniqueId();
        this.number = number;
        this.type= type;
    }

    public int getId(){return id; }
    public int setId(int id){return this.id= id; }
    public String getNumber() {return number;}
    public void setNumber(String number) {this.number = number; }
    public ContactType getType() {
        return type;
    }
    public void setType(ContactType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Numbers{" +
                "id= " + id +
                ", number='" + number + '\'' +
                ", type=" + type +
                '}';
    }


}
