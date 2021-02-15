
public class Floor {

    private Room[] rooms;
    private int numberOfRooms;

    public Floor() {
        numberOfRooms = 0;
        rooms = new Room[numberOfRooms];
    }

    public Floor(int x) {
        numberOfRooms = x;
        rooms = new Room[x];
    }

    public void addRoom(int idx, Room r) {
        rooms[idx] = r;
    }

    @Override
    public String toString() {
        String w = "";
        for (int i = 0; i < numberOfRooms; i++) {
            w += rooms[i];
            w += "\n";
        }
        return w;
    }

    public boolean isExist(int roomNumber) {

        for (int i = 0; i < numberOfRooms; i++) {
            if (rooms[i].getRoomnumber() == roomNumber) {
                return true;
            }
        }
        return false;
    }

    public void CancelReservation(int roomNumber) throws Exception {
        for (int i = 0; i < numberOfRooms; i++) {
            if (rooms[i].getRoomnumber() == roomNumber) {
                if (rooms[i].isReserved()) {
                    rooms[i].cancel();
                } else {
                    throw new RoomValidation("Room is not reserved!!");
                }
            }
        }
    }

    public void MakeReservation(int roomNumber, int days) throws Exception {
        for (int i = 0; i < numberOfRooms; i++) {
            if (rooms[i].getRoomnumber() == roomNumber) {
                if (!rooms[i].isReserved()) {
                    rooms[i].reserveTheRoom(days);
                } else {
                    throw new RoomValidation("\t\tRoom is already reserved!!\n");
                }
            }
        }
    }

    public double checkOut(int roomNumber) throws Exception {
        for (int i = 0; i < numberOfRooms; i++) {
            if (rooms[i].getRoomnumber() == roomNumber) {
                if (rooms[i].isReserved()) {
                    return rooms[i].totalPrice();
                } else {
                    throw new RoomValidation("\t\tRoom is not reserved!!\n");
                }
            }
        }
        return 0.0;
    }

    public String availableRooms() {
        String w = "";
        for (int i = 0; i < numberOfRooms; i++) {
            if (!rooms[i].isReserved()) {
                w += rooms[i];
                w += "\n";
            }
        }
        if (w.length() == 0) {
            return "Floor is fully complete\n";
        }
        return w;
    }

    public double expectedProfit() {
        double ret = 0.0;
        for (int i = 0; i < numberOfRooms; i++) {
            if (rooms[i].isReserved()) {
                ret += rooms[i].totalPrice();
            }
        }
        return ret;
    }
}
