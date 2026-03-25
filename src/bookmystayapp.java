import java.util.HashMap;

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay App – Room Inventory (UC3) ===");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();
    }
}

class RoomInventory {

    private HashMap<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single Room", 5);
        availability.put("Double Room", 3);
        availability.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int newCount) {
        availability.put(roomType, newCount);
    }

    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        System.out.println("------------------------");
        for (String roomType : availability.keySet()) {
            System.out.println(roomType + " → " + availability.get(roomType) + " available");
        }
    }
}