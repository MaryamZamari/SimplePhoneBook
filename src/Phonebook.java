import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int choice = 0;
        Map<String, String> phonebook = new HashMap<>();
        do{
            System.out.println();
            System.out.println("Welcome to Phonebook! \n" +
                                "select a menu item. \n" +
                                "type 1 for default message display.\n" +
                                "type 2 for registering ur name and number\n" +
                                "type 3 for printing all contacts\n" +
                                "type 0 to exit\n");
            choice= Integer.parseInt(input.nextLine());
            String name= "";
            String number= "";
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
                case 3:
                    System.out.println("phonebook size: "+ phonebook.size());
                    if(!phonebook.isEmpty()){
                        System.out.println("here are all the registered contacts up until now: ");
                        for(Map.Entry entry: phonebook.entrySet()){
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                    }else{
                        System.out.println("There are no contacts registered yet. proceed to register some!");
                    }
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
