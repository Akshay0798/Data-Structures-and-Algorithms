import java.util.HashMap;

public class ItineraryTicket {
    public static String getStart(HashMap<String, String> tick) {
        // Create a HashMap to store the reversed mapping of the given tickets
        HashMap<String, String> revMap = new HashMap<>();

        // Loop through the given tickets to create the reversed mapping
        for (String key : tick.keySet()) {
            // key -> key, val -> tick.get(key)
            // Without reversing, we will get the value, and we need to reverse it
            revMap.put(tick.get(key), key);
        }

        // Loop through the original tickets to find the starting point
        for (String key : tick.keySet()) {
            // If the current city (key) is not present in the reversed mapping,
            // it means it's the starting point of the itinerary
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null; // Return null if no valid starting point is found
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangalore");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        // Print the itinerary by following the connections in the tickets HashMap
        while (tickets.containsKey(start)) {
            System.out.print(start + "->");
            start = tickets.get(start); // Move to the next city using the value from the tickets map
        }

        System.out.println(start); // Print the last city in the itinerary
    }
}
