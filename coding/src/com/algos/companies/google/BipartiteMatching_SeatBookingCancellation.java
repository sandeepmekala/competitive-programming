package com.algos.companies.google;

import java.util.*;

public class BipartiteMatching_SeatBookingCancellation {

    public List<Integer> getCancelledSeats(int[][] bookings) {
        Map<Integer, Integer> seatMapping = new HashMap<>();
        for (int i = 0; i < bookings.length; i++) {
            find(seatMapping, bookings, i, new HashSet<>());
        }

        List<Integer> cancelled = new ArrayList<>();
        if (seatMapping.size() == bookings.length) {
            for (int i = 0; i < bookings.length; i++) {
                int seat1 = bookings[i][0];
                int seat2 = bookings[i][1];
                cancelled.add(seatMapping.get(seat1) == i ? seat2 : seat1);
            }
        }
        return cancelled;
    }

    private boolean find(Map<Integer, Integer> match, int[][] booking, int index, Set<Integer> vis) {
        for (int seat : booking[index]) {
            if (!vis.contains(seat)){
                vis.add(seat);
                if (!match.containsKey(seat) || find(match, booking, match.get(seat), vis)) {
                    match.put(seat, index);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BipartiteMatching_SeatBookingCancellation obj = new BipartiteMatching_SeatBookingCancellation();

        int[][] bookings = new int[][] { { 6, 2 },
                { 1, 2 },
                { 1, 6 },
                { 2, 3 },
                { 3, 4 },
                { 5, 2 } };

        List<Integer> cancellations = obj.getCancelledSeats(bookings);
        System.out.println(cancellations); // Output: [6, 2, 1, 2, 3, 2]
    }
}
