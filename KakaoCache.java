package baeckjoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KakaoCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(0,new String[] {"aaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaa"}));
	}
	static int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      Set<String> set = new HashSet<>();
	      Queue<String> q = new LinkedList<>();
	      for(int a=0;a<cities.length;a++) {
	    	  String city = cities[a].toLowerCase();
	    	  if(set.contains(city)) {
    			  q.remove(city);
    			  q.add(city);
	    		  answer+=1;
	    	  }else {
	    		  if(q.size()==cacheSize) {
	    			  String k=q.poll();
	    			  set.remove(k);
	    			  q.add(city);
	    			  set.add(city);
	    		  }else {
	    			  q.add(city);
	    			  set.add(city);
	    		  }
	    		  answer+=5;
	    	  }
	      }
	      return answer;
	  }

}
