package baeckjoon;

import java.util.Arrays;

public class kakao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ans1 [] = solution(5	,new int[] {9, 20, 28, 18, 11},new int[] {30, 1, 21, 17, 28});for(int a=0;a<5;a++) {
			System.out.println(ans1[a]);
		}
	}
	
	
	static String[] solution(int n, int[] arr1, int[] arr2) {
		String map[] = new String[n];
		for (int a = 0; a < n; a++) {
			StringBuilder st = new StringBuilder();
			String a1b = Integer.toBinaryString(arr1[a]);
			String a2b = Integer.toBinaryString(arr2[a]);
			if(a1b.length()>a2b.length()) {
				int num = a1b.length()-a2b.length();
				for(int b=0;b<a1b.length()-a2b.length();b++) {
					if(a1b.charAt(b)=='1') {
						st.append("#");
					}else {
						st.append(" ");
					}
				}
				for(int b=num;b<a1b.length();b++) {
					if(a1b.charAt(b)=='1' ||a2b.charAt(b-num)=='1' ) {
						st.append("#");
					}
					if(a1b.charAt(b)=='0' && a2b.charAt(b-num)=='0' ) {
						st.append(" ");
					}
				}
			
			}
			else if(a1b.length() < a2b.length()){
				int num = a2b.length()-a1b.length();
				for(int b=0;b<a2b.length()-a1b.length();b++) {
					if(a2b.charAt(b)=='1') {
						st.append("#");
					}else {
						st.append(" ");
					}
				}
				for(int b=num;b<a2b.length();b++) {
					if(a2b.charAt(b)=='1' ||a1b.charAt(b-num)=='1' ) {
						st.append("#");
					}
					if(a2b.charAt(b)=='0' && a1b.charAt(b-num)=='0' ) {
						st.append(" ");
					}
				}
			}
			else {
				for(int b=0;b<a2b.length();b++) {
					if(a2b.charAt(b)=='1' ||a1b.charAt(b)=='1' ) {
						st.append("#");
					}
					if(a2b.charAt(b)=='0' && a1b.charAt(b)=='0' ) {
						st.append(" ");
					}
				}
			}
			if(st.length()<n) {
				for(int b=0;b<n-st.length();b++) {
					st.insert(0," ");
				}
			}
			map[a]=st.toString();
			st=new StringBuilder();
		}
		return map;
	}

}
