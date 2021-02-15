
public class Standard extends Room {

    private int numberOfBeds;
    private double bedPrice;

    public Standard() {
        super();
        numberOfBeds = 1;
        bedPrice = 1;
    }

    public Standard(int roomnumber, int beds, double bedPrice, int daysOfReservation, boolean isresarve) {
        super(roomnumber, daysOfReservation, isresarve);
        numberOfBeds = beds;
        this.bedPrice = bedPrice;
    }
    public Standard(int x ,double y) {
        numberOfBeds = x;
        bedPrice = y;
    }


    @Override
    public double totalPrice() {
        return this.numberOfBeds * this.getDaysOfReservation() * this.bedPrice;
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
    public void cancel () {
        setBoolreser(false);
        setDaysOfReservation(0);
    }

    @Override
    public String toString() {
        String w = "\t\tStandard #" + this.getRoomnumber() + ", has " + this.numberOfBeds
                + " bed(s), price of a bed $" + this.bedPrice + "\n\t\t";
        if(isReserved())
            w+="Room is Not available NOW.\n";
        else w+= "Room is available NOW.\n";
        return w;
    }

}