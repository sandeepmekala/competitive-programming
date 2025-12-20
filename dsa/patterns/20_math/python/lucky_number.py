def is_lucky_number(n, counter):
    print("positin:", n, "counter:", counter)
    if counter > n:
        return True
    if n % counter == 0:
        return False

    return is_lucky_number(n - n // counter, counter + 1)


# ------------------ Test (Same as Java main) ------------------

n = 19
print(is_lucky_number(n, 2))
