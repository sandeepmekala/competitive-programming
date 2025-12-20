# Problem: https://leetcode.com/problems/lemonade-change/
# Idea: Greedy: Give change to the customer with maximum available denominations.
# Time: O(n)

def lemonadeChange(bills):
    fives = 0
    tens = 0

    for bill in bills:
        if bill == 5:
            fives += 1
        elif bill == 10:
            if fives > 0:
                fives -= 1
                tens += 1
            else:
                return False
        else:  # bill == 20
            # be greedy: give one 10 + one 5 first to save fives
            if tens > 0 and fives > 0:
                tens -= 1
                fives -= 1
            elif fives >= 3:
                fives -= 3
            else:
                return False

    return True


# -------- Test --------
bills = [5, 5, 5, 10, 20]
print(lemonadeChange(bills))   # True
