package udemy.strings;

import java.util.ArrayList;
import java.util.List;

public class BackspaceStringCompare {
	
	// BruteForce
	public static boolean stringCompare2(String str1, String str2) {
	    return (removeHash2(str1).equals(removeHash2(str2)));
	}
	
	public static List<Character> removeHash2(String str) {
	    List<Character> arrList = new ArrayList<>();
	    char[] charArr = str.toCharArray();
	    for (int i = 0; i < charArr.length ;i++) {
	            if (charArr[i] == '#' ) {
	                if (i > 0 && arrList.size() > 0 ) {
	                    arrList.remove(arrList.size()-1);
	                }
	            } else {
	                arrList.add(charArr[i]);
	            }
	    }
	    return arrList;
	}
	
	// Optimal
	public boolean backspaceCompare(String s, String t) {
		 int i = s.length() -1;
		    int j = t.length() -1;
		    while(i>= 0 || j >= 0){
		     if((i >= 0 && s.charAt(i) == '#') || (j >= 0 && t.charAt(j) == '#'))
		     {
		         if(i >= 0 && s.charAt(i) == '#'){
		           int backCount = 2;
		           while(backCount > 0){
		               i--;
		               backCount--;
		               if(i >= 0 && s.charAt(i) == '#'){
		                 backCount+= 2;   
		               }    
		           }
		         } 
		         if(j >= 0 && t.charAt(j) == '#'){
		            int backCount = 2;
		            while(backCount > 0){
		               j--;
		               backCount--;
		               if(j >= 0 && t.charAt(j) == '#'){
		                 backCount+= 2;   
		               }    
		           } 
		     }
		    }
		    else{
		        if(i < 0 || j < 0){
		            return false;
		        }
		        if(s.charAt(i) != t.charAt(j)) {
		            return false;
		        } else {
		            i--;
		            j--;
		        }
		    }
		}
		return true;
	}
	
}
