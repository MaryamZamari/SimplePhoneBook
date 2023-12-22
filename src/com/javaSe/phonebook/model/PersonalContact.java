package com.javaSe.phonebook.model;

import java.util.List;

public class PersonalContact extends Contact{
    private String surname;

    public PersonalContact(int id, String name, String surname, List<ContactNumber> numbers) {
        super(id, name, numbers);
        this.surname= capitaliseFirstLetter(surname);
        String nameSurname= surname + "." + name;
        idTracker.put(id, nameSurname);
        System.out.println("personal contact created");
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = capitaliseFirstLetter(surname);
    }


}
