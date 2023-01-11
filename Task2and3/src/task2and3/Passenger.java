package task2and3;
class Passenger {

    String firstName;
    String surname;
    int expenses;
    int id;
    int pos;

    Passenger(String pFirstName, String pSurname, int pExpenses, int pID, int pPosition) {//contructor method using given parameters
        firstName = pFirstName;
        surname = pSurname;
        expenses = pExpenses;
        id = pID;
        pos = pPosition;
    }
}