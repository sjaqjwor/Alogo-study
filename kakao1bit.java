package baeckjoon;

public class kakao1bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans [] = solution(6	,new int[] {46, 33, 33 ,22, 31, 50},new int[] {27 ,56, 19, 14, 14, 10});
		for(int a=0;a<6;a++) {
			System.out.println(ans[a]);
		}

	}
	 static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      for(int a=0;a<n;a++) {
	    	  int num = arr1[a]|arr2[a];
	    	  String bi = Integer.toBinaryString(num);
	    	  StringBuilder st = new StringBuilder(bi);
	    	  if(st.length()<n) {
	    		  for(int b=0;b<n-(st.length()-1);b++) {
	    			  st.insert(0," ");
	    		  }
	    	  }
	    	  answer[a]=st.toString().replace("0"," ").replace("1", "#");
	      }
	      return answer;
	  }

}
