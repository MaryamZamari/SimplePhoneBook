import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("Welcome to Phonebook! \n" +
                                "select a menu item. \n" +
                                "type 1 for default message display.\n" +
                                "type 2 for registering ur name and number\n" +
                                "type 00 to exit\n");
            choice= Integer.parseInt(input.nextLine());
            String name= "";
            String number= "";
            Map<String, String> phonebook = new HashMap<>();
            switch(choice){
                case 1: System.out.println("Hello World");
                break;
                case 2:
                    System.out.println("insert first your name and then ur phone number");
                    name= input.nextLine();
                    number= input.nextLine();
                    phonebook.put(name.toString() , number.toString());
                    System.out.println("your name is registered as " + name.toString().toUpperCase() + "and your number is " + number.toString() );
                    break;
                default:
                    if(choice != 00){
                        System.out.println("the selected number is invalid. try again!");
                    }

            }
        }while(choice != 00);




    }
}
