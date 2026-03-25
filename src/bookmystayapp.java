
import java.util.HashMap;

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay App – Room Search (UC4) ===");

        RoomInventory inventory = new RoomInventory();

        SearchService search = new SearchService(inventory);

        search.displayAvailableRooms();
    }
}

/
abstract class Room {
    protected String roomType;
    protected double pricePerNight;

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}


class SingleRoom extends Room {
    public SingleRoom() {
        roomType = "Single Room";
        pricePerNight = 2500.00;
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        roomType = "Double Room";
        pricePerNight = 4200.00;
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        roomType = "Suite Room";
        pricePerNight = 7500.00;
    }
}


class RoomInventory {

    private HashMap<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single Room", 5);
        availability.put("Double Room", 0);
        availability.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }
}


class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void displayAvailableRooms() {

        System.out.println("\nAvailable Rooms:");
        System.out.println("-------------------");

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {
            int count = inventory.getAvailability(room.getRoomType());
            if (count > 0) {
                System.out.println(room.getRoomType() + " | Price: ₹" + room.getPricePerNight() +
                        " | Available: " + count);
            }
        }
    }
}