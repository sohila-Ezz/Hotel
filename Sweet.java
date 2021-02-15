public class Sweet extends Room {
    double pricePerNight;
    public Sweet(){
        super();
        pricePerNight=200;
    }
    public Sweet(int roomnumber,double pricePerNight ,int daysOfReservation,boolean isresarve){
         super(roomnumber,daysOfReservation,isresarve);
         this.pricePerNight = pricePerNight;
    }

    @Override
    public double totalPrice() {
        return this.pricePerNight *  getDaysOfReservation();
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
        String  w = "\t\tSweet #" + getRoomnumber() + ", " ;
        w+= "Price per night = $" + pricePerNight + " \n\t\t";
        if(isReserved())
        w += "Room is NOT available NOW.\n";
        else w+= "Room is available NOW.\n";
        return w;
        
    }
}