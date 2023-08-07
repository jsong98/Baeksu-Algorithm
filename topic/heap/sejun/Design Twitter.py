from collections import defaultdict
import heapq

class Twitter:

    def __init__(self):
        self.time = 0
        self.tweetMap = defaultdict(list)
        self.followMap = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweetMap[userId].append([self.time, tweetId])
        self.time -= 1


    def getNewsFeed(self, userId: int) -> List[int]:
        count = 0
        minheap = []
        result = []

        if userId not in self.followMap[userId]:
            self.followMap[userId].add(userId)

        for follower in self.followMap[userId]:
            for news in self.tweetMap[follower]:
                minheap.append(news)
        heapq.heapify(minheap)
        while minheap:
            _, value = heapq.heappop(minheap)
            if count == 10:
                break
            else:
                result.append(value)
                count +=1
        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followMap[followerId].add(followeeId)


    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.followMap[followerId]:
            self.followMap[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)