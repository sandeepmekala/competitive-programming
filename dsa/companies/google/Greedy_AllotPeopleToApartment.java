
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Greedy_AllotPeopleToApartment {
    public static class Apartment {
        public int aptNumber;
        public int numRooms;

        public Apartment(int aptNumber, int numRooms) {
            this.aptNumber = aptNumber;
            this.numRooms = numRooms;
        }
    }

    public static class Person {
        public String name;
        public boolean wantsHousemates;

        public Person(String name, boolean wantsHousemates) {
            this.name = name;
            this.wantsHousemates = wantsHousemates;
        }
    }

    public static Map<Integer, List<String>> assignApartmentsToPeople(
            Collection<Apartment> apartments,
            Collection<Person> people) {

        // Split apartments into one-room and multi-room categories
        List<Apartment> oneRoomApartments = new ArrayList<>();
        List<Apartment> multiRoomApartments = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.numRooms == 1) {
                oneRoomApartments.add(apartment);
            } else {
                multiRoomApartments.add(apartment);
            }
        }

        // Split people into single preference and shared preference categories
        List<Person> singlePreference = new ArrayList<>();
        List<Person> sharedPreference = new ArrayList<>();
        for (Person person : people) {
            if (person.wantsHousemates) {
                sharedPreference.add(person);
            } else {
                singlePreference.add(person);
            }
        }

        // Match single preference people with one-room apartments
        Map<Integer, List<String>> assignmentMap = matchPreferences(oneRoomApartments, singlePreference);

        // Assign remaining single preference people to multi-room apartments while
        // considering their preference for housemates
        assignSinglePreferenceToMultiRoomApartments(assignmentMap, multiRoomApartments, singlePreference,
                sharedPreference);

        // Assign multi preference people to single-room apartments while considering
        // their preference for housemates
        assignMultiPreferenceToSingleRoomApartments(assignmentMap, oneRoomApartments, multiRoomApartments,
                sharedPreference);

        return assignmentMap;
    }

    // Method to match preferences between apartments and people
    private static Map<Integer, List<String>> matchPreferences(List<Apartment> apartments, List<Person> people) {
        Map<Integer, List<String>> apartmentNumberAndTenants = new HashMap<>();
        for (Apartment apartment : apartments) {
            int aptNumber = apartment.aptNumber;
            int numRooms = apartment.numRooms;
            List<String> tenants = new ArrayList<>();
            while (numRooms > 0 && !people.isEmpty()) {
                tenants.add(people.remove(0).name);
                numRooms--;
            }
            apartmentNumberAndTenants.put(aptNumber, tenants);
        }
        return apartmentNumberAndTenants;
    }

    // Method to assign single preference people to multi-room apartments while
    // considering their preference for housemates
    private static void assignSinglePreferenceToMultiRoomApartments(Map<Integer, List<String>> assignmentMap,
            List<Apartment> multiRoomApartments, List<Person> singlePreference, List<Person> sharedPreference) {
        for (Apartment apartment : multiRoomApartments) {
            int aptNumber = apartment.aptNumber;
            List<String> tenants = new ArrayList<>();
            while (apartment.numRooms > 0) {
                if (!sharedPreference.isEmpty()) {
                    tenants.add(sharedPreference.remove(0).name);
                    apartment.numRooms--;
                } else if (!singlePreference.isEmpty()) {
                    tenants.add(singlePreference.remove(0).name);
                    apartment.numRooms--;
                } else {
                    break; // No more people available
                }
            }
            assignmentMap.put(aptNumber, tenants);
        }
    }

    // Method to assign multi preference people to single-room apartments while
    // considering their preference for housemates
    private static void assignMultiPreferenceToSingleRoomApartments(Map<Integer, List<String>> assignmentMap,
            List<Apartment> oneRoomApartments, List<Apartment> multiRoomApartments, List<Person> sharedPreference) {
        for (Person person : sharedPreference) {
            boolean assigned = false;
            for (Apartment apartment : oneRoomApartments) {
                if (apartment.numRooms > 0) {
                    List<String> tenants = assignmentMap.getOrDefault(apartment.aptNumber, new ArrayList<>());
                    tenants.add(person.name);
                    assignmentMap.put(apartment.aptNumber, tenants);
                    apartment.numRooms--;
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                for (Apartment apartment : multiRoomApartments) {
                    if (apartment.numRooms > 0) {
                        List<String> tenants = assignmentMap.getOrDefault(apartment.aptNumber, new ArrayList<>());
                        tenants.add(person.name);
                        assignmentMap.put(apartment.aptNumber, tenants);
                        apartment.numRooms--;
                        assigned = true;
                        break;
                    }
                }
            }
            if (!assigned) {
                // No available apartments to assign
                System.out.println("No available apartments to assign " + person.name);
            }
        }
    }

    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(101, 1));
        apartments.add(new Apartment(102, 2));
        apartments.add(new Apartment(103, 1));
        apartments.add(new Apartment(104, 3));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Jean", true)); // Wants housemates
        people.add(new Person("Maria", false)); // Doesn't want housemates
        people.add(new Person("Alex", true));
        people.add(new Person("Xinyi", true));
        people.add(new Person("Filippo", true));
        people.add(new Person("Cameron", false));
        people.add(new Person("Vikki", true)); // Wants housemates

        Map<Integer, List<String>> assignmentMap = assignApartmentsToPeople(apartments, people);

        for (Map.Entry<Integer, List<String>> entry : assignmentMap.entrySet()) {
            int aptNumber = entry.getKey();
            List<String> assignedPeople = entry.getValue();
            if (aptNumber == -1) {
                System.out.println("Unassigned:");
            } else {
                System.out.println("Apartment " + aptNumber + ":");
            }
            for (String person : assignedPeople) {
                System.out.println("- " + person);
            }
        }
    }
}
