# Problem: https://www.lintcode.com/problem/659/
# Idea: You can't use simple delimieter as strings can also contain that delimiter.
# You can solve that, you have to store no of chars in each word.
# But this number can agian conflict with ints that can be there in words like ab23d.
# Hence, introduce a simbal after number to idetify that this number is used by us.
def encode(strs):
    result = []
    delimiter = "#"
    for s in strs:
        result.append(str(len(s)))
        result.append(delimiter)
        result.append(s)
    return "".join(result)


def decode(s):
    result = []
    i = 0
    n = len(s)

    while i < n:
        del_ind = s.index('#', i)
        length = int(s[i:del_ind])

        beg_ind = del_ind + 1
        end_ind = beg_ind + length
        result.append(s[beg_ind:end_ind])

        i = end_ind

    return result


# ------------------ Test (Same as Java main) ------------------

encoded = encode(["lintsfsdkjfsdkfjsdkfsd", "code", "love", "you"])
print(encoded)
print(decode(encoded))
