
import java.util.*;

public class Interval_OnCallRotation {

    public static void main(String[] args) {
        List<String[]> schedule = Arrays.asList(
            new String[]{"Abby", "1", "10"},
            new String[]{"Ben", "5", "7"},
            new String[]{"Carla", "6", "12"},
            new String[]{"David", "15", "17"}
        );

        List<Event> events = new ArrayList<>();

        for (String[] entry : schedule) {
            String name = entry[0];
            int start = Integer.parseInt(entry[1]);
            int end = Integer.parseInt(entry[2]);
            events.add(new Event(start, name, "start"));
            events.add(new Event(end, name, "end"));
        }

        events.sort((e1, e2) -> {
            if (e1.time != e2.time) {
                return Integer.compare(e1.time, e2.time);
            }
            return e1.type.equals("start") ? -1 : 1;
        });

        List<String> result = new ArrayList<>();
        Set<String> onCall = new HashSet<>();
        int currTime = events.get(0).time;

        //Sweep line
        for (Event event : events) {
            if (event.time != currTime) {
                if (!onCall.isEmpty()) {
                    result.add(formatResult(currTime, event.time, onCall));
                }
                currTime = event.time;
            }
            if (event.type.equals("start")) {
                onCall.add(event.name);
            } else {
                onCall.remove(event.name);
            }
        }

        // Print the final result
        for (String line : result) {
            System.out.println(line);
        }
    }

    private static String formatResult(int start, int end, Set<String> names) {
        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);
        return start + " " + end + " " + String.join(", ", sortedNames);
    }
}
class Event {
    int time;
    String name;
    String type;

    Event(int time, String name, String type) {
        this.time = time;
        this.name = name;
        this.type = type;
    }
}
