public class UseCase2RoomInitialization {

    private static int availableSingleRooms = 5;
    private static int availableDoubleRooms = 3;
    private static int availableSuites = 2;

    static abstract class Room {
        private String roomType;
        private int beds;
        private double price;

        public Room(String roomType, int beds, double price) {
            this.roomType = roomType;
            this.beds = beds;
            this.price = price;
        }

        public String getRoomType() { return roomType; }
        public int getBeds() { return beds; }
        public double getPrice() { return price; }

        public abstract String getDescription();
    }

    static class SingleRoom extends Room {
        public SingleRoom() { super("Single Room", 1, 1999.00); }
        public String getDescription() { return "Ideal for solo travelers."; }
    }

    static class DoubleRoom extends Room {
        public DoubleRoom() { super("Double Room", 2, 3499.00); }
        public String getDescription() { return "Comfortable for two guests."; }
    }

    static class SuiteRoom extends Room {
        public SuiteRoom() { super("Suite Room", 3, 5999.00); }
        public String getDescription() { return "Luxury suite with premium features."; }
    }

    public static void main(String[] args) {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        display(single, availableSingleRooms);
        display(doubleRoom, availableDoubleRooms);
        display(suite, availableSuites);
    }

    private static void display(Room room, int availability) {
        System.out.println("\nRoom Type: " + room.getRoomType());
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Price: ₹" + room.getPrice());
        System.out.println("Available: " + availability);
        System.out.println("Description: " + room.getDescription());
    }
}
