package topic.heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode_DesignTwitter {
	private static int timeStamp = 0;	// // 문제 해결을 위한 Tweet의 시간정보.

	private Map<Integer, User> userMap;	// userId와 User 객체를 mapping한 정보를 저장.

	private class Tweet {
		public int id;
		public int time;
		public Tweet next;

		public Tweet(int id) {
			this.id = id;
			time = timeStamp++;			
			next = null;
		}
	}
	
	public class User{			
		public int id;
		public Set<Integer> followed;
		public Tweet tweet_head;		// 해당 user의 Tweet 중 head. Tweet들을 연결리스트 형태로 저장.
		
		public User(int id) {
			this.id = id;
			followed = new HashSet<>();
			follow(id);					// 가장 먼저 자기 자신을 follow
			tweet_head = null;
		}
		
		public void follow(int id) {
			followed.add(id);
		}
		
		public void unfollow(int id) {
			followed.remove(id);
		}
		
		public void post(int id) {
			Tweet t = new Tweet(id);
			t.next=tweet_head;
			tweet_head=t;
		}
	}
	
	public Leetcode_DesignTwitter() {
		userMap = new HashMap<Integer, User>();
	}
	
	public void postTweet(int userId, int tweetId) {
		if(!userMap.containsKey(userId)) {		// 입력된 id를 가진 user가 있는지 체크
			User u = new User(userId);
			userMap.put(userId, u);
		}
		userMap.get(userId).post(tweetId);		// 있으면 User class의 post 메서드 호출
	}
	
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new LinkedList<>();		
		
		if(!userMap.containsKey(userId)) return res;
		
		Set<Integer> users = userMap.get(userId).followed;	// User의 followed는 HashSet
		PriorityQueue<Tweet> q = new PriorityQueue<>(users.size(), (a, b) -> (b.time-a.time));
		// Tweet을 저장할 우선순위큐 선언
		for(int user: users) {
			Tweet t = userMap.get(user).tweet_head;	// User 객체가 저장하고 있는 tweet을
			if(t!=null) {
				q.add(t);							// 우선순위큐에 저장
			}
		}
		int n = 0;
		while(!q.isEmpty() && n < 10) {
			Tweet t = q.poll();				// 우선순위큐에 있는 Tweet들
			res.add(t.id);					// id만 결과 List에 저장
			n++;							// 최대 10개
			if(t.next!=null) {				// t.next가 null이 아닐때까지 = 해당 user가 가진 모든 Tweet을 반환
				q.add(t.next);
			}
		}
		
		return res;
	}
	
	public void follow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId)) {
			User u = new User(followerId);
			userMap.put(followerId, u);
		}
		if(!userMap.containsKey(followeeId)) {
			User u = new User(followeeId);
			userMap.put(followeeId, u);
		}
		
		userMap.get(followerId).follow(followeeId);
	}
	
	public void unfollow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId) || followerId==followeeId) {
			return;
		}
		userMap.get(followerId).unfollow(followeeId);
	}
	
}
