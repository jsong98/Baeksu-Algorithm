package topic.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Topolocial Sort with indegree

public class CourseScheduleII {
	
	static class Course {
		int num;
		int indegree;
		
		public Course(int num, int indegree) {
			this.num = num;
			this.indegree = indegree;
		}
	}
	
	public static void main(String[] args) {
//		int numCourses = 4;
//		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		
		int numCourses = 3;
		int[][] prerequisites = {{1,0},{1,2},{0,1}};
		
//		int numCourses = 1;
//		int[][] prerequisites = {};
		
		findOrder(numCourses, prerequisites);
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> list = new ArrayList<>();
		int[] indegree = new int[numCourses];
		
		for(int i = 0; i < numCourses; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int[] arr : prerequisites) {
			int v1 = arr[0];
			int v2 = arr[1];
			
			list.get(v2).add(v1);
			indegree[v1]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> res = new LinkedList<>();
		
		for(int i = 0; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		
		while(!que.isEmpty()) {
			int node = que.poll();
			res.offer(node);
//			System.out.println(node);
			
			for(int linked : list.get(node)) {
				indegree[linked]--;
				
				if(indegree[linked]==0) {
					que.offer(linked);
				}
			}
		}
		
		int[] resArr = new int[res.size()];
		for(int i = 0; i < resArr.length; i++) {
			resArr[i] = res.poll();
		}
		if(resArr.length!=numCourses) return new int[] {};
//		System.out.println(Arrays.toString(resArr));
		return resArr;
	}
	
	
}
