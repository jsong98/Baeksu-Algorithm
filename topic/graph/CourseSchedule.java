package topic.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {

	private static boolean cycle = false;
	
	public static void main(String[] args) {
//		int numCourses = 5;
//		int[][] prerequisites = {{1, 0}, {0, 4}, {4, 2}, {3, 1}, {1, 2}};
		
		int numCourses = 6;
		int[][] prerequisites = {{0, 2}, {1, 3}, {3, 2}, {4, 1}, {2, 1}, {0, 3}};
		
//		int numCourses = 1;
//		int[][] prerequisites = {};
		
//		int numCourses = 2;
//		int[][] prerequisites = {{0, 1}};
		
		
		System.out.println(canFinish(numCourses, prerequisites));
	}
	
	public static boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edgelist: prerequisites){		// 선행과목 -> 피선행과목으로 directed graph
            int u = edgelist[1];		
            int v = edgelist[0];		

            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[n];
        boolean[] currentPath = new boolean[n];

        for(int i=0;i<n;i++){
            dfs(i, graph, visited, currentPath);
        }


        return !cycle;
    }
	
	public static void dfs(int v, ArrayList<ArrayList<Integer>> g, boolean[] vis, boolean[] cur){
        if(cur[v]){
            cycle = true;
        }

        if(vis[v] || cycle){
            return;
        }

        vis[v] = true;
        cur[v] = true;

        for(int adj: g.get(v)){
            dfs(adj, g, vis, cur);
        }

        cur[v] = false;
    }
}
