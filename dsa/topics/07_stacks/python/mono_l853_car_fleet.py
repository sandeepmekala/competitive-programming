"""
Problem: https://leetcode.com/problems/car-fleet/description/
Idea:
Move from right to left and build a monotonically increasing stack of times.
time = distance / speed
If a car takes more time than the car ahead, it forms a new fleet.
Otherwise, it merges into the existing fleet.
"""

def car_fleet(target, position, speed):
    # Pair position and speed, then sort by position
    cars = sorted(zip(position, speed))

    stack = []  # stack of times to reach target

    # Traverse from right to left
    for pos, spd in reversed(cars):
        time = (target - pos) / spd

        # If this car takes longer, it forms a new fleet
        if not stack or time > stack[-1]:
            stack.append(time)

    return len(stack)


# Example usage
if __name__ == "__main__":
    target = 12
    position = [10, 8, 0, 5, 3]
    speed = [2, 4, 1, 1, 3]
    print(car_fleet(target, position, speed))  # 3
