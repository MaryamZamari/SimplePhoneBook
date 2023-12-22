package com.javaSe.phonebook.model;

import java.util.List;

public class BusinessContact extends Contact{
    private String vatNumber;

    public BusinessContact(int id, String name, List<ContactNumber> numbers, String vatNumber){
        super(id, name, numbers);
        this.vatNumber= vatNumber;
        String nameFaxNum= vatNumber + "." + name;
        idTracker.put(id, vatNumber);
    }

    public String getVatNumber(){
        return this.vatNumber;
    }




}
