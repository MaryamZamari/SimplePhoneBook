package com.javaSe.phonebook.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class Contact {
    private static int idCounter= 0;
    public static Map<Integer, String> idTracker= new HashMap<>();
    private int id;
    private String name;

    private List<ContactNumber> numbers;

    public Contact(int id, String name, List<ContactNumber> numbers) {
        this.id= generateUniqueId();
        this.name = name;
        this.numbers = numbers;
    }

    public Contact(String name, List<ContactNumber> numbers) {
        this.id= generateUniqueId();
        this.name = capitaliseFirstLetter(name);
        this.numbers = numbers;
    }

    public static int generateUniqueId() {
        return idCounter++;
    }
    public String capitaliseFirstLetter(String str){
        if(!str.isEmpty() && str != null){
          return  Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = capitaliseFirstLetter(name);
    }

    public String getNumbers() {
        return numbers.toString();
    }

    public void setNumber(int id , ContactNumber newNumber) {
        Optional<ContactNumber> currentNumber = Optional.ofNullable(this.numbers.get(id));
        if (currentNumber.isPresent()) {
            currentNumber.get().setNumber(newNumber.getNumber());
            currentNumber.get().setType(newNumber.getType());
            System.out.println(currentNumber.toString() + " changed to: " + newNumber.toString());
        } else {
            System.out.println("The requested number does not exist!");
        }
    }

    public void addNumber(ContactNumber number) {
        this.numbers.add(number);
    }

    public void deleteNumber(int id) {
        if (this.numbers.size() > 1) {
            ContactNumber number= numbers.get(id);
            this.numbers.remove(number);
            System.out.println("your new contact is added!");
        } else {
            throw new RuntimeException("There is no other number for this contact. if you proceed, the contact will be deleted all together!");
        }
    }

    public void printAllNumbersOfContact(){
        if(!numbers.isEmpty()){
            System.out.println("All the numbers associated with " +
                    "the requested contact" +
                    "are as follows: ");
            for(ContactNumber n: numbers){
                System.out.println(n);
            }
         }else{
            System.out.println("There is no number associated to " +
                                "this contact! proceed to add some!");
        }
      }

    @Override
    public String toString() {
        return "com.javaSe.phonebook.model.Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numbers='" + numbers + '\'' +
                '}';
    }


}
