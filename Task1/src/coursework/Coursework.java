package coursework;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Cabin{
    String cName;
    int cid;
    Cabin(String cabinName, int cabinID){
        cName = cabinName;
        cid = cabinID;
    }
}

class Passenger {
    String firstName;
    String surname;
    int expenses;
    int id;
    Passenger(String pFirstName, String pSurname, int pExpenses, int pID){
        firstName = pFirstName;
        surname = pSurname;
        expenses = pExpenses;
        id = pID;
    }
}

public class Coursework {

    static final int NOOFCABINS = 12;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum = 0;
        String[] cruiseShip = new String[13];
        initialise(cruiseShip);
        
        for(int i = 0; i <20; i++){
            System.out.println("");
            System.out.println("Please Enter your choice");
            System.out.println(" A: To Add customers To cabin\n" +
                            " V: Display All cabins\n" +
                            " E: Display Empty cabins\n" +
                            " D: Delete customer from cabin\n" +
                            " F: Find cabin from customer name\n" +
                            " S: Store program data into file\n" +
                            " L: Load program data from file\n" +
                            " O: View passengers Ordered alphabetically by name");
            char choice = input.next().charAt(0);
            if(choice == 'A' ){
                addCustomer(cruiseShip);
            } else if(choice == 'V'){
                veiwAllCabins(cruiseShip);
            } else if(choice == 'E'){
                veiwEmptyCabins(cruiseShip);
            } else if(choice == 'D'){
                deleteCustomer(cruiseShip);
            } else if(choice == 'F'){
                findCustomer(cruiseShip);
            } else if(choice == 'S'){
                storeArray(cruiseShip);
            } else if(choice == 'L'){
                loadArray();
            } else if(choice == 'O'){
                passengersSorted(cruiseShip);
            } else if(choice == 'T'){
                
            }
        }
    }

    private static void initialise(String cruiseShipRef[]) {
        for (int x = 0; x < NOOFCABINS; x++) {
            cruiseShipRef[x] = "e";
        }
        System.out.println("Initialise");
    }
    
    private static void addCustomer(String[] cruiseShipRef) {
                
        Passenger[] passengers = new Passenger[11];
        Cabin[] cabins = new Cabin[3];
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (0-11) or 12 to stop: ");
        int roomNum = input.nextInt();
        
        if (roomNum >= 0 && roomNum < NOOFCABINS) {
            System.out.println("Enter Your First Name: ");
            String fName = input.next();
            System.out.println("Enter Your Surname: ");
            String sName = input.next();
            int customerExpenses = 0;
            int customerID = 0;
            passengers[roomNum] = new Passenger(fName, sName, customerExpenses, customerID);
            System.out.println(passengers[0]);
        } else {
            System.out.println("Invalid room number");
        }
        String cName = "hello";
        int cID = 0;
        cabins[roomNum] = new Cabin(cName, cID);
    }

    private static void veiwAllCabins(String cruiseShipRef[]) {
        for (int x = 0; x < NOOFCABINS; x++) {
            System.out.println("Room " + x + " is occupied by " + cruiseShipRef[x]);
        }
    }

    private static void veiwEmptyCabins(String[] cruiseShipRef) {
        for (int x = 0; x < NOOFCABINS; x++) {
            if (cruiseShipRef[x].equals("e")) {
                System.out.println("Room " + x + " is empty");
            }
        }
    }
    
    private static void deleteCustomer(String[] cruiseShipRef){
        System.out.println("Please enter a cabin number to delete:");
        Scanner input = new Scanner(System.in);
        int cabinNum = input.nextInt();
        System.out.println("Deleted customer from cabin: " + cabinNum);
        cruiseShipRef[cabinNum]  = "e";
    }

    private static void findCustomer(String[] cruiseShipRef){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the customer name: ");
        String customerName = input.next();
        
        for(int x = 0; x < NOOFCABINS; x++){
            if(cruiseShipRef[x] != "e"){
                System.out.println(customerName + " is in room: " + x);
            }
        }
    }
    
    private static void storeArray(String[] cruiseShipRef) throws IOException{
        FileWriter writer = new FileWriter("C:\\Users\\lolbo\\Documents\\Lecture notes\\Software development 2\\Coursework\\Coursework\\src\\coursework\\cabins.txt");
        int len = cruiseShipRef.length;
        for(int i = 0; i < len; i++){
            writer.write(cruiseShipRef[i] + "\n" + "");
        }
        writer.close();
    }
    
    private static void loadArray(){
        int lineCount = 1;
        try{
            File inputFile = new File("C:\\Users\\lolbo\\Documents\\Lecture notes\\Software development 2\\Coursework\\Coursework\\src\\coursework\\cabins.txt");
            Scanner rf = new Scanner(inputFile);
            String fileLine;
            while(rf.hasNext()){
                fileLine = rf.nextLine();
                System.out.println(lineCount + " " + fileLine);
                lineCount++;
            }
            rf.close();
        } catch(IOException e){
            System.out.println("Error IOException is: " + e);
        }
    }
    
    private static void passengersSorted(String[] cruiseShipRef){
        String sortedCruiseShip[] = new String[12];
        
        for(int x = 0; x < 12; x++){
            sortedCruiseShip[x] = cruiseShipRef[x];//This moves the array into a new array to not mess up the original order of cabins
        }
        
        String temp;//create a temporary variable to store the cabin names while their switched
        for(int i = 0; i < sortedCruiseShip.length - 1; i++){//Starts a loop that looks at the first item of the list
            for(int j = i; j < sortedCruiseShip.length - 1; j++){//Starts a loop that looks at the second item of the list
                char first = sortedCruiseShip[i].charAt(0);//Looks at the first character of the element
                char sec = sortedCruiseShip[j + 1].charAt(0);//looks at the first character of the secoind element
                if(first > sec){//If the first char is before the second char
                    temp = sortedCruiseShip[j + 1];//store it in the temporary variable
                    sortedCruiseShip[j + 1] = sortedCruiseShip[i];//Move the first item into the second position
                    sortedCruiseShip[i] = temp;//Move the second element to the first position
                }
            }
            System.out.println(Arrays.toString(sortedCruiseShip));//Prints out the new sorted list
        }
    }
}