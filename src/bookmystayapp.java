import java.util.*;

public class UseCase6RoomAllocationService {
     private Queue<String> bookingRequestQueue = new LinkedList<>();

    private Map<String, Integer> roomInventory = new HashMap<>();

    private Set<String> allocatedRoomIDs = new HashSet<>();


    private Map<String, Set<String>> roomTypeAllocations = new HashMap<>();

    public UseCase6RoomAllocationService() {
        roomInventory.put("Deluxe", 3);
        roomInventory.put("Suite", 2);
        roomInventory.put("Standard", 4);

        roomTypeAllocations.put("Deluxe", new HashSet<>());
        roomTypeAllocations.put("Suite", new HashSet<>());
        roomTypeAllocations.put("Standard", new HashSet<>());
    }



    public void addBookingRequest(String roomType) {
        System.out.println("Booking Request Added: " + roomType);
        bookingRequestQueue.add(roomType);
    }



    public void processReservations() {
        while (!bookingRequestQueue.isEmpty()) {

            String requestedType = bookingRequestQueue.poll();  // FIFO
            System.out.println("\nProcessing booking request for room type: " + requestedType);


            if (!roomInventory.containsKey(requestedType)) {
                System.out.println("Invalid room type. Cannot allocate.");
                continue;
            }

            if (roomInventory.get(requestedType) <= 0) {
                System.out.println("No rooms available for type: " + requestedType);
                continue;
            }


            String assignedRoomID = generateUniqueRoomID(requestedType);


            if (assignedRoomID == null) {
                System.out.println("Unable to assign a unique room ID!");
                continue;
            }


            allocatedRoomIDs.add(assignedRoomID);
            roomTypeAllocations.get(requestedType).add(assignedRoomID);


            roomInventory.put(requestedType, roomInventory.get(requestedType) - 1);

            System.out.println("✅ Reservation Confirmed!");
            System.out.println("Assigned Room ID: " + assignedRoomID);
            System.out.println("Remaining " + requestedType + " rooms: " + roomInventory.get(requestedType));
        }
    }
    private String generateUniqueRoomID(String roomType) {
        while (true) {
            String id = roomType.substring(0, 2).toUpperCase() + "-" + (int)(Math.random() * 9000 + 1000);

            if (!allocatedRoomIDs.contains(id)) {
                return id;
            }
        }
    }



    public void showAllocationReport() {
        System.out.println("\n==============================");
        System.out.println(" FINAL ROOM ALLOCATION REPORT");
        System.out.println("==============================");

        for (String type : roomTypeAllocations.keySet()) {
            System.out.println("Room Type: " + type);
            System.out.println("Allocated Rooms: " + roomTypeAllocations.get(type));
            System.out.println("Remaining Inventory: " + roomInventory.get(type));
            System.out.println();
        }
    }



    public static void main(String[] args) {

        UseCase6RoomAllocationService service = new UseCase6RoomAllocationService();


        service.addBookingRequest("Deluxe");
        service.addBookingRequest("Suite");
        service.addBookingRequest("Suite");
        service.addBookingRequest("Deluxe");
        service.addBookingRequest("Standard");
        service.addBookingRequest("Deluxe");
        service.addBookingRequest("Suite");
        service.processReservations();
        service.showAllocationReport();
    }
}