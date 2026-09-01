# Problem: https://leetcode.com/problems/car-pooling/
# Companies: Amazon
# Idea: We have to process the trips in start order. Hence sort them on start.
# All the trips that we are picking, we need to find the first ending trip to remove it from car.
# Hence, load picked trips to a min-heap (priority queue) based on ending.
# Sorting on end alone will not work as we don't know which trips will be picked up.
import heapq

def car_pooling(trips, capacity):
    # sort trips by start location
    trips.sort(key=lambda x: x[1])

    # min-heap based on end location
    pq = []  # each entry: (end, passengers)
    curr_pass = 0

    for passengers, start, end in trips:
        # remove all trips that have already ended
        while pq and pq[0][0] <= start:
            ended_end, ended_pass = heapq.heappop(pq)
            curr_pass -= ended_pass

        # add current trip
        curr_pass += passengers
        heapq.heappush(pq, (end, passengers))

        if curr_pass > capacity:
            return False

    return True


# ------------------ Test (Same as Java main) ------------------

trips = [[2, 1, 5], [3, 3, 7]]
print(car_pooling(trips, 4))  # Expected: False
