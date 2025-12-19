import heapq

"""
Problem: Merge K Sorted Arrays
Idea: Use a min heap.
Push the first element of each array along with (array_index, element_index).
Each pop gives the next smallest element, then push the next element from the same array.
"""
def merge_k_sorted_arrays(arrays):
    min_heap = []
    total_len = sum(len(arr) for arr in arrays)

    # push first element of each array
    for i, arr in enumerate(arrays):
        if arr:
            heapq.heappush(min_heap, (arr[0], i, 0))  # value, array_index, element_index

    result = []
    while min_heap:
        val, arr_i, idx = heapq.heappop(min_heap)
        result.append(val)

        if idx + 1 < len(arrays[arr_i]):
            next_val = arrays[arr_i][idx + 1]
            heapq.heappush(min_heap, (next_val, arr_i, idx + 1))

    return result


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    arrays = [
        [1, 4, 5],
        [1, 3, 4],
        [2, 6]
    ]
    print(merge_k_sorted_arrays(arrays))
