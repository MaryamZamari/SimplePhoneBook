package com.javaSe.phonebook.controller;

import com.javaSe.phonebook.model.*;
import com.javaSe.phonebook.service.Phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    private static Phonebook phonebook= new Phonebook();

    public static void main(String[] args){
        Runner runner= new Runner();
        Scanner input= new Scanner(System.in);
        int choice = 0;
        do{
            runner.printMenu();
            System.out.println();
            choice= parseInt(input.nextLine());
            switch(choice){
                case 1:
                    Contact newContact= runner.createContactFromInput(input);
                    phonebook.addContact(newContact);
                    break;
                case 2:
                    System.out.println("enter the id of the contact you wish to change: ");
                    int contactId= Integer.parseInt(input.nextLine());
                    newContact= runner.getContactInfoFromUserForEdit(input, contactId);
                    phonebook.setContactList(contactId, newContact);
                    break;
                case 3:
                    System.out.println("enter the id of the contact you wish to remove: ");
                    contactId= Integer.parseInt(input.nextLine());
                    phonebook.removeContact(contactId);
                    break;
                case 4:
                    phonebook.printAllContacts();
                    break;
                default:
                    if(choice != 00){
                        System.out.println("the selected number is invalid. try again!");
                    }
            }
        }while(choice != 00);

        input.close();


    }







}
