package topic.topologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {

	public static void main(String[] args) {
		int[][] graph = {{1,2},{2,3},{5},{4},{}};
//		int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
//		int[][] graph = {{},{0,2,3,4},{3},{4},{}};
		
		eventualSafeNodes(graph);
	}
	
	public static boolean dfs(List<List<Integer>> adj, int src, boolean[] vis, boolean[] termi) {
        vis[src] = true;
        termi[src] = true;
        for (int x : adj.get(src)) {
            if (!vis[x] && dfs(adj, x, vis, termi)) {
                return true;
            } else if (termi[x]) {
                return true;
            }
        }
        termi[src] = false;
        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            adj.add(list);
        }
        boolean[] vis = new boolean[n];
        boolean[] termi = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, termi);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < termi.length; i++) {
            if (!termi[i]) {
            	res.add(i);
            }
        }
        
//        System.out.println(res.toString());
        return res;
    }
}
