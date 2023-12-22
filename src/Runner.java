import com.javaSe.phonebook.model.*;
import com.javaSe.phonebook.service.Phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
                    int contactId= runner.getContactIdFromUser(input);
                    newContact= runner.createContactFromInput(input);
                    phonebook.setContactList(contactId, newContact);
                    break;
                case 3:
                    contactId= runner.getContactIdFromUser(input);
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

    public void printMenu() {
        System.out.println();
        System.out.println("Welcome to Phonebook! \n" +
                "select a menu item. \n" +
                "type 1 for adding a new contact.\n" +
                "type 2 for editing a contact\n" +
                "type 3 for removing a contact\n" +
                "type 4 for printing all the contacts." +
                "type 0 to exit\n");
    }

    //get contactId for remove/edit
    public int getContactIdFromUser(Scanner input){
        System.out.println("type the name of the contact you wish to retrieve:");
        String name= input.next().trim();
        System.out.println("if it is a personal contact, type the surname, otherwise type the VAT number: ");
        String surname= input.next().trim();
        String nameSurname= surname + "." + name;
        Map<Integer, String> idTracker= Contact.idTracker;
        int id = 0;
        for(Map.Entry<Integer, String> entry : idTracker.entrySet()){
            if(entry.getValue().equals(nameSurname)){
                id= entry.getKey().intValue();
            }
        }
        return id;
    }

    public Contact createContactFromInput(Scanner input){
        Contact newContact = null;
        String surname;
        String vatNumber;
        System.out.println("Enter Name: ");
        String name= input.nextLine();
        System.out.println("how many numbers do you want to add?");
        int n= parseInt(input.next());
        List<ContactNumber> numbers= new ArrayList<>();
        for(int i=0; i< n; i++) {
            ContactNumber number = this.getContactNumberFromUser(input);
            numbers.add(number);
        }
        System.out.println("Enter P for Personal and B for business contact: ");
        char typeInput = input.next().toUpperCase().charAt(0);
        if(typeInput == 'P'){
            System.out.println("Enter surname: ");
            surname= input.nextLine();
            newContact= new PersonalContact(Contact.generateUniqueId(), name, surname, numbers);
        }else if(typeInput == 'B'){
            System.out.println("enter VAT number: ");
            vatNumber= input.nextLine();
            newContact= new BusinessContact(Contact.generateUniqueId(), name, numbers, vatNumber);
        }
        return newContact;
    }

    public ContactNumber getContactNumberFromUser(Scanner input){
        ContactType type = null;
        System.out.println("Enter P for personal number and B for Business");
        char typeInput = input.next().toUpperCase().charAt(0);
        if(typeInput == 'P'){
            type= ContactType.PERSONAL;
        }else if(typeInput == 'B'){
            type= ContactType.BUSINESS;
        }
        System.out.println("Enter the number: ");
        String number= input.next();
        ContactNumber newNumber= new ContactNumber(number, type);
        return newNumber;
    }



}
