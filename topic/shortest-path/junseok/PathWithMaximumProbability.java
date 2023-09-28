package topic.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumProbability {
	
	static class Pair{
		int key;
		double value;
		Pair(int x, double y) {
			this.key = x;
			this.value = y;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public double getValue() {
			return value;
		}
		public void setValue(double value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
		double[] succProb = {0.37,0.17,0.93,0.23,0.39,0.04};
		int start = 3;
		int end = 4;
		
		System.out.println(maxProbability(n, edges, succProb, start, end));
	}

	public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		HashMap<Integer, List<Pair>> map = new HashMap<>();
		
		for(int i = 0; i < edges.length; i++) {
			int start = edges[i][0];
			int end = edges[i][1];
			double weight = succProb[i];
			
			// 모든 간선에 대해 start정점을 key로, end정점과 weight값을 map에 저장
			map.computeIfAbsent(start, k->new ArrayList<>()).add(new Pair(end, weight));
			map.computeIfAbsent(end, k->new ArrayList<>()).add(new Pair(start, weight));
		}
		
		double[] dis = new double[n];	
		// maxProbability를 찾는 것이기 때문에 굳이 초기화x
		dis[start_node] = 1.0;
		
		// weight값을 기반으로 한 heap
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->-Double.compare(a.getValue(),b.getValue()));
		
		pq.add(new Pair(start_node, 1.0));
		
		// Dijkstra algo
        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.getKey()==end_node)return curr.getValue();
            for(Pair path: map.getOrDefault(curr.getKey(),new ArrayList<>())){
            	// 현재 heap에서 꺼낸 Pair객체, curr와 연결된 값들 중에서 curr의 weight를 곱했을 때 더 커지면
            	// 곱한 값을 dis와 que에 넣음
                if((curr.getValue()*path.getValue())>dis[path.getKey()]){
                	dis[path.getKey()] = (double)curr.getValue()* path.getValue();
                    pq.add(new Pair(path.getKey(), dis[path.getKey()]));
                }
            }
        }
		
//		System.out.println(Arrays.toString(dis));
		
		return dis[end_node];
	}
	
}
