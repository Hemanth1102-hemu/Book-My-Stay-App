import java.util.LinkedList;
import java.util.Queue;

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay App – Booking Requests (UC5) ===");

        BookingQueue bookingQueue = new BookingQueue();

        bookingQueue.addRequest(new Reservation("Hemanth", "Single Room"));
        bookingQueue.addRequest(new Reservation("Arjun", "Double Room"));
        bookingQueue.addRequest(new Reservation("Meera", "Suite Room"));

        bookingQueue.displayAllRequests();
    }
}
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
    public String getGuestName() {
        return guestName;
    }
    public String getRoomType() {
        return roomType;
    }
}
class BookingQueue {
    private Queue<Reservation> requestQueue;

    public BookingQueue() {
        requestQueue = new LinkedList<>();
    }
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Request added → " + reservation.getGuestName()
                + " | Room: " + reservation.getRoomType());
    }

    public void displayAllRequests() {
        System.out.println("\nPending Booking Requests (FIFO Order):");
        System.out.println("--------------------------------------");

        for (Reservation r : requestQueue) {
            System.out.println("Guest: " + r.getGuestName()
                    + " | Room Type: " + r.getRoomType());
        }
    }
}