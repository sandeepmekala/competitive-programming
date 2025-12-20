# Problem: https://leetcode.com/problems/design-twitter/
# Idea:
# - Maintain tweets with timestamps
# - Maintain follow relationships
# - Use a max-heap (priority queue) ordered by time to build news feed
#
# postTweet: O(1)
# follow / unfollow: O(1)
# getNewsFeed: O(n log n) in worst case (acceptable for interview)

import heapq
from collections import defaultdict

class Twitter:

    class Twit:
        def __init__(self, tweetId, time):
            self.tweetId = tweetId
            self.time = time

        # for max heap (reverse time)
        def __lt__(self, other):
            return self.time > other.time

    def __init__(self):
        self.follows = defaultdict(set)      # user -> set of followees
        self.twits = defaultdict(list)       # user -> list of tweets
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.time += 1
        self.twits[userId].append(self.Twit(tweetId, self.time))

    def getNewsFeed(self, userId: int):
        pq = []

        # user's own tweets
        for twit in self.twits[userId]:
            heapq.heappush(pq, twit)

        # followees' tweets
        for followee in self.follows[userId]:
            for twit in self.twits[followee]:
                heapq.heappush(pq, twit)

        feed = []
        while pq and len(feed) < 10:
            feed.append(heapq.heappop(pq).tweetId)

        return feed

    def follow(self, followerId: int, followeeId: int) -> None:
        self.follows[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.follows:
            self.follows[followerId].discard(followeeId)


# ---------------- Test (same as Java main) ----------------

obj = Twitter()
obj.postTweet(1, 5)
print(obj.getNewsFeed(1))      # [5]
obj.follow(1, 2)
obj.postTweet(2, 6)
print(obj.getNewsFeed(1))      # [6, 5]
obj.unfollow(1, 2)
print(obj.getNewsFeed(1))      # [5]
