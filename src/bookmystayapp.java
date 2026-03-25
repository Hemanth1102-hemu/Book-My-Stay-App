import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;
    private String roomID;

    public Reservation(String guestName, String roomType, String roomID) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomID = roomID;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomID() {
        return roomID;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", Room Type: " + roomType + ", Room ID: " + roomID;
    }
}

public class UseCase8BookingHistoryReport {


    private List<Reservation> bookingHistory = new ArrayList<>();



    public void addReservationToHistory(String guestName, String roomType, String roomID) {
        Reservation reservation = new Reservation(guestName, roomType, roomID);
        bookingHistory.add(reservation);

        System.out.println("✔ Added to Booking History → " + reservation);
    }



    public void showCompleteBookingHistory() {
        System.out.println("\n==============================");
        System.out.println("     COMPLETE BOOKING HISTORY ");
        System.out.println("==============================");

        if (bookingHistory.isEmpty()) {
            System.out.println("No bookings found!");
            return;
        }

        for (Reservation r : bookingHistory) {
            System.out.println(r);
        }
    }



    public void generateSummaryReport() {
        System.out.println("\n==============================");
        System.out.println("        SUMMARY REPORT");
        System.out.println("==============================");

        if (bookingHistory.isEmpty()) {
            System.out.println("No data available for summary.");
            return;
        }

        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : bookingHistory) {
            roomTypeCount.put(r.getRoomType(),
                    roomTypeCount.getOrDefault(r.getRoomType(), 0) + 1);
        }

        for (String roomType : roomTypeCount.keySet()) {
            System.out.println(roomType + " Rooms Booked: " + roomTypeCount.get(roomType));
        }
    }


    public static void main(String[] args) {

        UseCase8BookingHistoryReport reportSystem = new UseCase8BookingHistoryReport();


        reportSystem.addReservationToHistory("Arjun", "Deluxe", "DE-1023");
        reportSystem.addReservationToHistory("Priya", "Suite", "SU-8764");
        reportSystem.addReservationToHistory("Rahul", "Standard", "ST-2211");
        reportSystem.addReservationToHistory("Meera", "Deluxe", "DE-3421");

                reportSystem.showCompleteBookingHistory();

               reportSystem.generateSummaryReport();
    }
}