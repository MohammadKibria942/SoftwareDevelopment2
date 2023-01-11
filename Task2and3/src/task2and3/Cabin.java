package task2and3;
class Cabin {//new class SCabin
    
    String cabinName;
    int cabinPos;
    int cabinID;
    String cabinOccupy;
    Passenger[] passengers = new Passenger[36];//create an array that will store passengers
    //class takes in a cabinPos and cabinID

    Cabin(int cID, String cabinOcc) {//constructor method useing given parameters
        cabinID = cID;
        cabinOccupy = cabinOcc;
    }
}