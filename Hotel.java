
import java.util.*;

public class Hotel {
    private Floor[] floors;
    private int numberOfFloors;

    public Hotel() {
        this(0);
    }

    public Hotel(int x) {
        numberOfFloors = x;
        floors = new Floor[numberOfFloors];
    }
    public void initFloor(int idx , int x){
        floors[idx] = new Floor(x);
    }
    public void addRoom(int fidx, int ridx, Room r) {
        floors[fidx].addRoom(ridx, r);
    }

    @Override
    public String toString() {
        String w = "Hotel\n";
        for (int i = 0; i < numberOfFloors; i++) {
            w += "\tFloor #" + (i + 1) + ":\n";
            w += floors[i];
            w += "\n";
        }
        return w;
    }

    public void CancelReservation(int roomNumber) throws Exception {
        boolean Exist = false;
        for (int i = 0; i < numberOfFloors; i++) {
            if (floors[i].isExist(roomNumber)) {
                Exist = true;
                floors[i].CancelReservation(roomNumber);
                break;
            }
        }
        if (!Exist)
            throw new InvalidRoom("\t\tInvalid Room Number\n");
    }

    public void MakeReservation(int roomNumber, int days) throws Exception {
        boolean Exist = false;
        for (int i = 0; i < numberOfFloors; i++) {
            if (floors[i].isExist(roomNumber)) {
                Exist = true;
                floors[i].MakeReservation(roomNumber, days);
                break;
            }
        }
        if (!Exist)
            throw new InvalidRoom("\t\tInvalid Room Number\n");
    }

    public double checkOut(int roomNumber) throws Exception {
        boolean Exist = false;
        for (int i = 0; i < numberOfFloors; i++) {
            if (floors[i].isExist(roomNumber)) {
                Exist = true;
                return floors[i].checkOut(roomNumber);
            }
        }
        if (!Exist)
            throw new InvalidRoom("\n\t\tInvalid Room Number\n");
        return 0.0;
    }

    public String availableRooms(int idx)throws Exception{
       if(idx>= numberOfFloors)
            throw new InvalidFloor("\n\t\tInvalid Floor Number");
       if(idx < 0 )
           throw new InvalidInput("\n\t\tInvalid Input\n");
        return floors[idx].availableRooms();
    }

    public double expectedProfits(){
        double ret = 0.0;
        for(int i = 0 ; i <numberOfFloors;i++){
            ret += floors[i].expectedProfit();
        }
        return ret;
    }
}
