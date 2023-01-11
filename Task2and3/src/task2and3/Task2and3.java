package task2and3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.*;
import java.util.Scanner;

public class Task2and3 {

    public static Queue waitingQueue = new LinkedList();//create a queue for overflowing passengers
    public static int queueID;//the queue id is the psoition in the queue
    public static int[] tempQueue = new int[36];//temporary queue list

    //variables to find how many passengers fit into one cabin
    public static int cabin0Count = 0;
    public static int cabin1Count = 0;
    public static int cabin2Count = 0;
    public static int cabin3Count = 0;
    public static int cabin4Count = 0;
    public static int cabin5Count = 0;
    public static int cabin6Count = 0;
    public static int cabin7Count = 0;
    public static int cabin8Count = 0;
    public static int cabin9Count = 0;
    public static int cabin10Count = 0;
    public static int cabin11Count = 0;

    //creates variables to check the position of each cabin and if its occupied or not
    public static int cabin0Pos = 0;
    public static int cabin1Pos = 0;
    public static int cabin2Pos = 0;
    public static int cabin3Pos = 0;
    public static int cabin4Pos = 0;
    public static int cabin5Pos = 0;
    public static int cabin6Pos = 0;
    public static int cabin7Pos = 0;
    public static int cabin8Pos = 0;
    public static int cabin9Pos = 0;
    public static int cabin10Pos = 0;
    public static int cabin11Pos = 0;

    public static int spaceCount = 0;//how much space has been used(how many passengers have been checked in

    public static Cabin[] cabins = new Cabin[12];//place all created cabin objects into an array

    public static Passenger[] passengers = new Passenger[36];//create an array that will store passengers

    static final int NOOFCABINS = 12;//static number of rooms maximum of 36
    
    public static Scanner input = new Scanner(System.in);//create a global scanner variable which is used for user inputs

    public static void main(String[] args) throws IOException {
        String[] cruiseShip = new String[13];//creates a new array of cruiseships where passenegrs are stored
        initialise(cruiseShip);//calls the initialise function with the cruiseship as argument
        char choice = 'Z';//sets the choice to Z so that the while loop, loops

        while (choice != 'C') {//loops while the choice does not equal C which the the symbol to stop the loop
            System.out.println("");//adds space to seperate lines

            System.out.println("Please Enter your choice");//outputs all the options
            //prints the menu options
            System.out.println("""
                                A: To Add customers To cabin
                                V: Display All cabins
                                E: Display Empty cabins
                                D: Delete customer from cabin
                                F: Find cabin from customer name
                                S: Store program data into file
                                L: Load program data from file
                                O: View passengers Ordered alphabetically by name
                                T: View expenses
                                C: To stop
                               """);
            choice = input.next().charAt(0); //stores the users choice
            if (choice == 'A') {//if the choice is equal to A
                addCustomer(cruiseShip);     //call the addCustomer function with the cruiseShip as an argument
            } else if (choice == 'V') {//else if the choice 
                veiwAllCabins(cruiseShip);   //calls the fucntion to view all cabins
            } else if (choice == 'E') {//if the choice is e then
                veiwEmptyCabins(cruiseShip); //calls the funtion to view all the empty cabons
            } else if (choice == 'D') {
                deleteCustomer(cruiseShip);  //calls the function to delet a passenger from the cruiship
            } else if (choice == 'F') {
                findCustomer(cruiseShip);    //calls the fincustomer function thta searches for a passenger in the cruiship
            } else if (choice == 'S') {
                storeArray(cruiseShip);      //function for storing the cruiship to a file
            } else if (choice == 'L') {
                loadArray();                 //function that loads the cruiship from a file
            } else if (choice == 'O') {
                passengersSorted(cruiseShip);//function that ssorts passengers in the cruiseship
            } else if (choice == 'T') {
                expenses();                  //function that calculates the passengers expenses
            } else if (choice == 'C') {
                System.out.println("Stopped the programme");
            }
        }
    }

    private static void initialise(String cruiseShipRef[]) {//this is the initialise function where the cabins and arrays are initialised
        int tempA = 0;//create a temporary variable to inititalise cabins
        String tempB = "e";

        for (int x = 0; x < NOOFCABINS; x++) {//loop from 0 to the number of rooms
            cruiseShipRef[x] = "e";//store e to signify that the there are no passengers and that it is empty
        }
        System.out.println("Initialise");//print this when all elements are initialised

        for (int x = 0; x < NOOFCABINS; x++) {
            cabins[x] = new Cabin(tempA, tempB);
        }
    }

    public static void addCustomer(String cruiseShipRef[]) {
        int cabinID = 0;//cabin ID for which cabin passengers go in
        int customerExpenses = 100;//customer expenses

        System.out.println("Enter Cabin number (0-11) or 12 to stop: ");
        int cabinNum = input.nextInt();                                 //store the roomnumber
        System.out.println("Enter Your First Name: ");
        String fName = input.next();                                    //store the passenger name
        System.out.println("Enter Your Surname: ");
        String sName = input.next();                                    //store the passenger surname
        cruiseShipRef[cabinNum] = fName;                  //store the passengers name inside the roomnumber in the cruiseship array
        int customerPos = cabinNum;                                     //the customer position in the cvvbins is the roomnumber that was chosen

        if (cabinNum >= 0 && cabinNum < 12) {                       //if the roomnumber is above 0 and less than 12
            System.out.println(spaceCount);                         //print out how many customers have been checked in for debuggin purposes
            if (cabinNum == 0 && cabin0Count < 3) {              //if the customerPos(roomnumber) is equal to 0 and cabin0 has space then
                cabinID = 1;                //set the cabin id to 0
                cabins[0].cabinID = cabinID;      // store the cabin id inside the cabin0 object
                cabin0Count += 1;           //increment cabin0 count by 1
                if (cabin0Pos == 0) {
                    cabin0Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin0Pos);//create a new passengeedr using all the parameters.
                    cabin0Pos += 1;
                } else if (cabin0Pos == 1) {
                    cabin0Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin0Pos);//create a new passengeedr using all the parameters.
                    cabin0Pos += 1;
                } else if (cabin0Pos == 2) {
                    cabin0Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin0Pos);//create a new passengeedr using all the parameters.
                    cabin0Pos += 1;
                } else if (cabin0Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;            //increment the space to show that a passenger has been booked

            } else if (cabinNum == 1 && cabin1Count < 3) {
                cabinID = 2;
                cabins[1].cabinID = cabinID;
                cabin1Count += 1;
                if (cabin1Pos == 0) {
                    cabin1Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin1Pos);//create a new passengeedr using all the parameters.
                    cabin1Pos += 1;
                } else if (cabin1Pos == 1) {
                    cabin1Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin1Pos);//create a new passengeedr using all the parameters.
                    cabin1Pos += 1;
                } else if (cabin1Pos == 2) {
                    cabin1Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin1Pos);//create a new passengeedr using all the parameters.
                    cabin1Pos += 1;
                } else if (cabin1Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 2 && cabin2Count < 3) {
                cabinID = 3;
                cabins[2].cabinID = cabinID;
                cabin2Count += 1;
                if (cabin2Pos == 0) {
                    cabin2Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin2Pos);//create a new passengeedr using all the parameters.
                    cabin2Pos += 1;
                } else if (cabin2Pos == 1) {
                    cabin2Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin2Pos);//create a new passengeedr using all the parameters.
                    cabin2Pos += 1;
                } else if (cabin2Pos == 2) {
                    cabin2Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin2Pos);//create a new passengeedr using all the parameters.
                    cabin2Pos += 1;
                } else if (cabin2Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 3 && cabin3Count < 3) {
                cabinID = 4;
                cabins[3].cabinID = cabinID;
                cabin3Count += 1;
                if (cabin3Pos == 0) {
                    cabin3Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin3Pos);//create a new passengeedr using all the parameters.
                    cabin3Pos += 1;
                } else if (cabin3Pos == 1) {
                    cabin3Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin3Pos);//create a new passengeedr using all the parameters.
                    cabin3Pos += 1;
                } else if (cabin3Pos == 2) {
                    cabin3Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin3Pos);//create a new passengeedr using all the parameters.
                    cabin3Pos += 1;
                } else if (cabin3Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 4 && cabin4Count < 3) {
                cabinID = 5;
                cabins[4].cabinID = cabinID;
                cabin4Count += 1;
                if (cabin4Pos == 0) {
                    cabin4Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin4Pos);//create a new passengeedr using all the parameters.
                    cabin4Pos += 1;
                } else if (cabin4Pos == 1) {
                    cabin4Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin4Pos);//create a new passengeedr using all the parameters.
                    cabin4Pos += 1;
                } else if (cabin4Pos == 2) {
                    cabin4Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin4Pos);//create a new passengeedr using all the parameters.
                    cabin4Pos += 1;
                } else if (cabin4Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 5 && cabin3Count < 3) {
                cabinID = 6;
                cabins[5].cabinID = cabinID;
                cabin5Count += 1;
                if (cabin5Pos == 0) {
                    cabin5Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin5Pos);//create a new passengeedr using all the parameters.
                    cabin5Pos += 1;
                } else if (cabin5Pos == 1) {
                    cabin5Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin5Pos);//create a new passengeedr using all the parameters.
                    cabin5Pos += 1;
                } else if (cabin5Pos == 2) {
                    cabin5Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin5Pos);//create a new passengeedr using all the parameters.
                    cabin5Pos += 1;
                } else if (cabin5Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 6 && cabin3Count < 3) {
                cabinID = 7;
                cabins[6].cabinID = cabinID;
                cabin6Count += 1;
                if (cabin6Pos == 0) {
                    cabin6Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin6Pos);//create a new passengeedr using all the parameters.
                    cabin6Pos += 1;
                } else if (cabin6Pos == 1) {
                    cabin6Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin6Pos);//create a new passengeedr using all the parameters.
                    cabin6Pos += 1;
                } else if (cabin6Pos == 2) {
                    cabin6Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin6Pos);//create a new passengeedr using all the parameters.
                    cabin6Pos += 1;
                } else if (cabin6Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 7 && cabin3Count < 3) {
                cabinID = 8;
                cabins[7].cabinID = cabinID;
                cabin7Count += 1;
                if (cabin7Pos == 0) {
                    cabin7Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin7Pos);//create a new passengeedr using all the parameters.
                    cabin7Pos += 1;
                } else if (cabin7Pos == 1) {
                    cabin7Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin7Pos);//create a new passengeedr using all the parameters.
                    cabin7Pos += 1;
                } else if (cabin7Pos == 2) {
                    cabin7Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin7Pos);//create a new passengeedr using all the parameters.
                    cabin7Pos += 1;
                } else if (cabin7Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 8 && cabin3Count < 3) {
                cabinID = 9;
                cabins[8].cabinID = cabinID;
                cabin8Count += 1;
                if (cabin8Pos == 0) {
                    cabin8Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin8Pos);//create a new passengeedr using all the parameters.
                    cabin8Pos += 1;
                } else if (cabin8Pos == 1) {
                    cabin8Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin8Pos);//create a new passengeedr using all the parameters.
                    cabin8Pos += 1;
                } else if (cabin8Pos == 2) {
                    cabin8Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin8Pos);//create a new passengeedr using all the parameters.
                    cabin8Pos += 1;
                } else if (cabin8Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 9 && cabin3Count < 3) {
                cabinID = 10;
                cabins[9].cabinID = cabinID;
                cabin9Count += 1;
                if (cabin9Pos == 0) {
                    cabin9Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin9Pos);//create a new passengeedr using all the parameters.
                    cabin9Pos += 1;
                } else if (cabin9Pos == 1) {
                    cabin9Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin9Pos);//create a new passengeedr using all the parameters.
                    cabin9Pos += 1;
                } else if (cabin9Pos == 2) {
                    cabin9Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin9Pos);//create a new passengeedr using all the parameters.
                    cabin9Pos += 1;
                } else if (cabin9Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 10 && cabin3Count < 3) {
                cabinID = 11;
                cabins[10].cabinID = cabinID;
                cabin10Count += 1;
                if (cabin10Pos == 0) {
                    cabin10Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin10Pos);//create a new passengeedr using all the parameters.
                    cabin10Pos += 1;
                } else if (cabin10Pos == 1) {
                    cabin10Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin10Pos);//create a new passengeedr using all the parameters.
                    cabin10Pos += 1;
                } else if (cabin10Pos == 2) {
                    cabin10Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin10Pos);//create a new passengeedr using all the parameters.
                    cabin10Pos += 1;
                } else if (cabin10Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            } else if (cabinNum == 11 && cabin3Count < 3) {
                cabinID = 12;
                cabins[11].cabinID = cabinID;
                cabin11Count += 1;
                if (cabin11Pos == 0) {
                    cabin11Pos = 0;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin11Pos);//create a new passengeedr using all the parameters.
                    cabin11Pos += 1;
                } else if (cabin11Pos == 1) {
                    cabin11Pos = 1;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin11Pos);//create a new passengeedr using all the parameters.
                    cabin11Pos += 1;
                } else if (cabin11Pos == 2) {
                    cabin11Pos = 2;
                    passengers[spaceCount] = new Passenger(fName, sName, customerExpenses, cabinID, cabin11Pos);//create a new passengeedr using all the parameters.
                    cabin11Pos += 1;
                } else if (cabin11Pos >= 3) {
                    System.out.println("No space in this cabin");
                }
                spaceCount += 1;

            }
        } else {
            System.out.println("You have beeen placed in a waiting queue");

            queueID = spaceCount + 1;
            passengers[queueID] = new Passenger(fName, sName, customerExpenses, queueID, customerPos);
            tempQueue[queueID] = queueID;
            waitingQueue.add(passengers[queueID]);
            System.out.println(waitingQueue);
        }
    }

    private static void veiwAllCabins(String cruiseShipRef[]) {
        for (int x = 0; x < NOOFCABINS; x++) {//loops the number of cabins in the cruiseship
            System.out.println("Cabin:" + x);

            System.out.println();
        }
    }

    private static void veiwEmptyCabins(String[] cruiseShipRef) {
        for (int x = 0; x < NOOFCABINS; x++) {//loops from 0- number of rooms
            if (cabins[x].cabinOccupy.equals("e")) {//if the current cruiship room is empty0
                System.out.println("Room " + x + " is empty");//if it is empty print the room number 
            }
        }
    }

    private static void deleteCustomer(String[] cruiseShipRef) {
        String fname;
        String sname;
        int cExpenses;
        int cabinId;
        int customerPos;

        System.out.println("Please enter a room number to delete:");
        int cabinNum = input.nextInt();
        System.out.println("Deleted customer from cabin: " + cabinNum);
        cruiseShipRef[cabinNum] = "e";
        if (!waitingQueue.isEmpty()) {
            fname = passengers[queueID].firstName;
            sname = passengers[queueID].surname;
            cExpenses = passengers[queueID].expenses;
            cabinId = passengers[queueID].id;
            customerPos = passengers[queueID].pos;

            cruiseShipRef[cabinNum] = fname;
            passengers[cabinNum] = passengers[queueID];

            //get the cabin stuff pos the which cabin store it in the cabin the passsenegr
            //then store the got cabin crap into the cruisshipref
            waitingQueue.poll();

        }
    }

    private static void findCustomer(String[] cruiseShipRef) {
        System.out.println("Please enter the customer name: ");//ask to input the customer name
        String customerName = input.next();//stores the entered name

        for (int x = 0; x < NOOFCABINS; x++) {//loops from 0- number of rooms
            if (passengers[x].firstName.equals(customerName)) {//check sto see if the current customer is the searched passenger
                System.out.println(customerName + " is in room: " + x);//if yes then print the room number
            }
        }
    }

    private static void storeArray(String[] cruiseShipRef) throws IOException {
        try (FileWriter writer = new FileWriter("C:\\Users\\lolbo\\Documents\\Lecture notes\\Software development 2\\Coursework\\Coursework\\src\\coursework\\cabins.txt")) {
            int len = cruiseShipRef.length;
            for (int i = 0; i < len; i++) {
                writer.write(cruiseShipRef[i] + "\n" + "");
            }
        }
    }

    private static void loadArray() {
        int lineCount = 1;
        try {
            File inputFile = new File("C:\\Users\\lolbo\\Documents\\Lecture notes\\Software development 2\\Coursework\\Coursework\\src\\coursework\\cabins.txt");
            try (Scanner rf = new Scanner(inputFile)) {
                String fileLine;
                while (rf.hasNext()) {
                    fileLine = rf.nextLine();
                    System.out.println(lineCount + " " + fileLine);
                    lineCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
        }
    }

    private static void passengersSorted(String[] cruiseShipRef) {
        String sortedCruiseShip[] = new String[12];

        for (int x = 0; x < 12; x++) {
            sortedCruiseShip[x] = cruiseShipRef[x];//This moves the array into a new array to not mess up the original order of cabins
        }

        String temp;//create a temporary variable to store the cabin names while their switched
        for (int i = 0; i < sortedCruiseShip.length - 1; i++) {//Starts a loop that looks at the first item of the list
            for (int j = i; j < sortedCruiseShip.length - 1; j++) {//Starts a loop that looks at the second item of the list
                char first = sortedCruiseShip[i].charAt(0);//Looks at the first character of the element
                char sec = sortedCruiseShip[j + 1].charAt(0);//looks at the first character of the secoind element
                if (first > sec) {//If the first char is before the second char
                    temp = sortedCruiseShip[j + 1];//store it in the temporary variable
                    sortedCruiseShip[j + 1] = sortedCruiseShip[i];//Move the first item into the second position
                    sortedCruiseShip[i] = temp;//Move the second element to the first position
                }
            }
            System.out.println(Arrays.toString(sortedCruiseShip));//Prints out the new sorted list
        }
    }

    private static void expenses() {
        int choice;//a new variable for the choice
        System.out.println("Please Enter your choice");
        System.out.println("""
                            1: Print the expenses per passenger
                            2: Print the total of all passengers
                           """);
        choice = input.nextInt();//store user choice
        int total = 0;//new vraibale called total;
        if (choice == 1) {//if choice is 1
            for (int x = 0; x < NOOFCABINS; x++) {
                //loop through all the passengers and display their expenses
                System.out.println("First Name: " + passengers[x].firstName + " Surname: " + passengers[x].surname + " Cabin:" + passengers[x].id + " Expenses: £" + passengers[x].expenses);
            }
        } else if (choice == 2) {//if choice is 2
            for (int x = 0; x < NOOFCABINS; x++) {
                //loops though all the passengers and adds the expenses of all passengers and prints it
                total = total + passengers[x].expenses;
                System.out.println(total);
            }
        }
    }
}