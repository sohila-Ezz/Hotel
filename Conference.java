
public class Conference extends Room {

    private int numberOfSeats;
    private double seatPrice;

    public Conference(int roomnumber, int numberOfSeats, double seatPrice, int daysOfReservation, boolean rserv) {
        super(roomnumber, daysOfReservation, rserv);
        this.numberOfSeats = numberOfSeats;
        this.seatPrice = seatPrice;
    }

    public Conference() {
        super();
    }

    @Override
    public double totalPrice() {
        return this.numberOfSeats * this.getDaysOfReservation() * this.seatPrice;
    }

    @Override
    public boolean isReserved() {
        return isBoolreser();
    }

    @Override
    public void reserveTheRoom(int days) {
        setBoolreser(true);
        setDaysOfReservation(days);
    }

    @Override
    public void cancel() {
        setBoolreser(false);
        setDaysOfReservation(0);
    }

    @Override
    public String toString() {
        String w = "\t\tconference #" + this.getRoomnumber() + ", has " + this.numberOfSeats
                + " seat(s) ,price of seat $" + this.seatPrice + ".\n";
        if (isReserved()) {
            w += "\t\tRoom is Not available NOW\n";
        } else {
            w += "\t\tRoom is available NOW\n";
        }
        return w;
    }

}
