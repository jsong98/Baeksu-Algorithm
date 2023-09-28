package topic.unionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AccountsMerge {

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		
		
	}
	
//	Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
//    Map<String, String> name = new HashMap<>();        //<email, username>
//
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//
//        // Building the graph
//        for(List<String> account : accounts){
//            // ["John","johnsmith@mail.com","john_newyork@mail.com"]
//            // we will connect first email to every email in a star pattern
//            String username = account.get(0);
//            for(int i=1; i<account.size(); i++){
//                name.put(account.get(i), username); //connect email to username
//                if(!graph.containsKey(account.get(i))){
//                    graph.put(account.get(i), new HashSet<>());
//                }
//
//                if(i==1) continue;
//                graph.get(account.get(i)).add(account.get(i - 1)); // other -> first email
//                graph.get(account.get(i - 1)).add(account.get(i)); // first -> other email
//            }
//        }
//
//        Set<String> visited = new HashSet<>();
//        List<List<String>> res = new LinkedList<>();
//        // DFS search the graph;
//        for (String email : name.keySet()) {
//            List<String> list = new ArrayList<>();
//            if (visited.add(email)) {
//                dfs(graph, email, visited, list);
//                Collections.sort(list); // sort as demanded in question
//                list.add(0, name.get(email)); // add username at first
//                res.add(list); // add to result
//            }    
//        }
//        return res;
//    }
//
//    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
//        list.add(email);
//        for (String next : graph.get(email)) {
//            if (visited.add(next)) {
//                dfs(graph, next, visited, list);
//            }
//        }
//    }

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> res = new ArrayList<>();
		outer :
		for(List<String> account : accounts) {
			if(res.isEmpty()) {
				res.add(account);
				continue;
			}
			for(int i = 0; i < res.size(); i++) {
				List<String> comp = res.get(i);
				if(account.get(0).equals(comp.get(0))) {
					if(isSameP(account, comp)) {
						List<String> uni = union(account, comp);
						Collections.sort(uni);
						res.remove(i);
						res.add(i, uni);
						continue outer;
					}
				} 
			}
			res.add(account);
		}
		
		List<List<String>> temp = new ArrayList<>();
		List<String> tempList = new ArrayList<>();
		for(int i = 0; i < res.size(); i++) {
			for(int j = 1; j < res.get(i).size(); j++) {
				tempList.add(res.get(i).get(j));
			}
			tempList.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					char[] arr1 = o1.toCharArray();
					char[] arr2 = o1.toCharArray();
					for(int i = 0; i < arr1.length; i++) {
						if(arr1[i] != arr2[i]) {
							return arr1[i] - arr2[i];
						}
					}
					
					return -1;
				}
			});
			tempList.add(0, res.get(i).get(0));
			temp.add(tempList);
		}
		
		temp.sort(new Comparator<List<String>>() {

			@Override
			public int compare(List<String> o1, List<String> o2) {
				char[] arr1 = o1.get(0).toCharArray();
				char[] arr2 = o1.get(0).toCharArray();
				for(int i = 0; i < arr1.length; i++) {
					if(arr1[i] != arr2[i]) {
						return arr1[i] - arr2[i];
					}
				}
				
				return -1;
			}
		});
		
		return res;
	}
	
	public static boolean isSameP(List<String> account, List<String> comp) {
		for(int i = 1; i < account.size(); i++)
			if (comp.contains(account.get(i))) {
				return true;
			}

		return false;
	}

	public static List<String> union(List<String> account, List<String> comp) {
		for(String s : account) {
			if(!comp.contains(s)) {
				comp.add(s);
			}
		}
		
		return comp;
	}
	
}
