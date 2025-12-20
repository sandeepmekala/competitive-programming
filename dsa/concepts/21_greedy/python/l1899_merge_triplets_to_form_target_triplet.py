# Problem: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
# Idea: First eliminate all the triplets which has atleast one position value greater then the corresponding position value of target.
# Then check if any of the triples in remaining list have needed target values.
# If all the positions in target have a matching value in atleast one of the triplet, return true.

def mergeTriplets(triplets, target):
    seen = set()

    for triplet in triplets:
        if (triplet[0] <= target[0] and
            triplet[1] <= target[1] and
            triplet[2] <= target[2]):

            for i in range(3):
                if triplet[i] == target[i]:
                    seen.add(i)

    return len(seen) == 3


# -------- Test --------
triplets = [[2,5,3],[1,8,4],[1,7,5]]
target = [2,7,5]
print(mergeTriplets(triplets, target))  # True
