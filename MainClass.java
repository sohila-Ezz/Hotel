
import java.io.*;
import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        try {
            File fileStream = new File("test.txt");
            Scanner in = new Scanner(fileStream);
            int x = readNumberOfFloors(in);
            Hotel H = new Hotel(x);
            for (int i = 0; i < x; i++) {
                int r = readNumberOfRooms(in);
                H.initFloor(i, r);
                for (int j = 0; j < r; j++) {
                    readARoom(in, H, i, j);
                }
            }
            in.close();
            Scanner input = new Scanner(System.in);
            program(H, input);

        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int readNumberOfFloors(Scanner in) {
        String s = in.nextLine().trim();
        int ret = Integer.parseInt(s.split(" ")[1]);
        return ret;
    }

    private static int readNumberOfRooms(Scanner in) {
        return Integer.parseInt(in.nextLine().trim().split(":")[1].trim());
    }

    private static void readARoom(Scanner in, Hotel h, int fidx, int ridx) {
        String s = in.nextLine().trim();
        s = s.substring(0, s.length() - 1);
        String[] r = s.split(",");
        for (int i = 0; i < r.length; i++) {
            r[i] = r[i].trim();
        }
        int rn = Integer.parseInt(r[1]);
        if (r[0].equals("Standard")) {
            int beds = Integer.parseInt(r[2]);
            double bp = Double.parseDouble(r[3]);
            h.addRoom(fidx, ridx, new Standard(rn, beds, bp, 0, false));
        } else if (r[0].equals("Sweet")) {
            double night = Double.parseDouble(r[2]);
            h.addRoom(fidx, ridx, new Sweet(rn, night, 0, false));
        } else if (r[0].equals("Conference")) {
            int ns = Integer.parseInt(r[2]);
            double sp = Double.parseDouble(r[3]);
            h.addRoom(fidx, ridx, new Conference(rn, ns, sp, 0, false));
        }
    }

    private static void showMenu() {
        System.out.print("Welcom To The Hotel\n");
        System.out.print("Enter 1: view the status of the hotel\n");
        System.out.print("Enter 2: make reservation\n");
        System.out.print("Enter 3: cancel reservation\n");
        System.out.print("Enter 4: display the price of the stay\n");
        System.out.print("Enter 5: display available rooms in a particular floor\n");
        System.out.print("Enter 6: display the total expected profit\n");
        System.out.print("Enter 7: Exit\n");
        System.out.print("Your Option : ");
    }

    private static void cancel(Hotel h, Scanner in) throws Exception {
        System.out.print("Enter Room Number : ");
        int rn = in.nextInt();
        h.CancelReservation(rn);
    }
    private static void reserve(Hotel h, Scanner in) throws Exception {
        System.out.print("Enter Room Number : ");
        int rn = in.nextInt();
        System.out.print("Enter days of reservation : ");
        int days = in.nextInt();
        h.MakeReservation(rn, days);
        System.out.println("\n\nSuccefully, reseved the room.\n");
    }
    private static void checkOut(Hotel h, Scanner in) throws Exception {
        System.out.print("Enter Room Number : ");
        int rn = in.nextInt();
        double x = h.checkOut(rn);
        h.CancelReservation(rn);
        System.out.println("Succefully Checked out, totalPrice = " + x + "\n");
    }
    private static void availableRooms(Hotel h, Scanner in) throws Exception {
        System.out.print("Enter Floor Number : ");
        int idx = in.nextInt();
        idx--;
        System.out.println(h.availableRooms(idx)+ "\n");
    }

    private static void expectedProfit(Hotel h, Scanner in) {
        System.out.println("Current Expected Profits = " + h.expectedProfits() + "\n");
    }
    private static void program(Hotel h, Scanner in) {
        int click = 0;
        do {
            try {
                showMenu();
                click = in.nextInt();
                switch (click) {
                    case 1:
                        System.out.println(h);
                        break;
                    case 2:
                        reserve(h, in);
                        break;
                    case 3:
                        cancel(h, in);
                        break;
                    case 4:
                        checkOut(h, in);
                        break;
                    case 5:
                        availableRooms(h, in);
                        break;
                    case 6:
                        expectedProfit(h, in);
                        break;
                    case 7:
                        break;
                    default:
                        throw new InvalidInput("\n\t\tInvalid Input\n");
                }
            } catch (InvalidInput ex) {
                System.out.println(ex.getMessage());
            } catch (InputMismatchException ex) {
                System.out.println("\n\t\tPlease, Enter an integer number\n");
                in.nextLine();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (click != 7);
    }

}
