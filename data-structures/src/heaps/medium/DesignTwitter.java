package heaps.medium;

import java.util.*;

public class DesignTwitter {

    record Tweet(int timestamp, int userId, int tweetId) implements Comparable<Tweet> {

        @Override
        public int compareTo(Tweet other) {
            return Integer.compare(other.timestamp, this.timestamp);
        }
    }

    private final Map<Integer, Set<Integer>> userRelationMap = new HashMap<>();
    private final Map<Integer, List<Tweet>> userTweets = new HashMap<>();
    private int timestampCounter = 0;

    public DesignTwitter() {

    }

    public void postTweet(int userId, int tweetId) {
        userRelationMap.computeIfAbsent(userId, k -> new HashSet<>());
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(timestampCounter++, userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userRelationMap.containsKey(userId)) {
            return result;
        }
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>();

        List<Tweet> userOwnTweets = userTweets.getOrDefault(userId, new ArrayList<>());
        for (Tweet tweet : userOwnTweets) {
            maxHeap.add(tweet);
            if (maxHeap.size() > 10) {
                maxHeap.poll();
            }
        }

        Set<Integer> followers = userRelationMap.get(userId);
        for (int followerId : followers) {
            List<Tweet> followerTweets = userTweets.getOrDefault(followerId, new ArrayList<>());
            for (Tweet tweet : followerTweets) {
                maxHeap.add(tweet);
                if (maxHeap.size() > 10) {
                    maxHeap.poll();
                }
            }
        }

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().tweetId());
        }

        Collections.reverse(result);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        userRelationMap.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = userRelationMap.getOrDefault(followerId, new HashSet<>());
        if (!followers.isEmpty()) {
            followers.remove(followeeId);
        }
    }

}


