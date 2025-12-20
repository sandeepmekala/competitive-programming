# Problem: https://leetcode.com/problems/student-attendance-record-i/
# Idea: Use to vars to track absents and lates.
def check_record(s):
    absents = 0
    lates = 0

    for ch in s:
        if ch == 'A':
            absents += 1
            lates = 0
            if absents >= 2:
                return False
        elif ch == 'L':
            lates += 1
            if lates >= 3:
                return False
        else:
            lates = 0

    return True


# ------------------ Test (Same as Java main) ------------------

print(check_record("PPALLP"))  # Expected: True
