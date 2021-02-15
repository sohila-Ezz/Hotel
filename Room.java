
public abstract class Room {
	private int roomnumber;
	private int daysOfReservation;
	private boolean boolreser;

	Room() {

	}

	Room(int roomnumber, int daysOfReservation, boolean isres) {
		this.roomnumber = roomnumber;
		this.daysOfReservation = daysOfReservation;
		this.boolreser = isres;
	}

	public boolean isBoolreser() {
		return boolreser;
	}

	public void setBoolreser(boolean boolreser) {
		this.boolreser = boolreser;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public int getDaysOfReservation() {
		return daysOfReservation;
	}

	public void setDaysOfReservation(int daysOfReservation) {
		this.daysOfReservation = daysOfReservation;
	}

	public abstract double totalPrice();

	public abstract boolean isReserved();

	public abstract void reserveTheRoom(int days);

	public abstract void  cancel();
}
