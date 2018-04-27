package baeckjoon;

import java.util.Scanner;

public class bj1701 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		int result=0;
		for(int a=0;a<str.length();a++) {
			result=Math.max(result,max(str.substring(a, str.length())));
		}
		System.out.println(result);
	}
	static int max(String k) {
		int arr[] = new int[k.length()];
		int j = 0,max=0;
		for(int a=1;a<k.length();a++) {
			while(j>0 && k.charAt(a)!=k.charAt(j)) {
				j=arr[j-1];
			}
			if(k.charAt(j)==k.charAt(a)) {
				max=Math.max(max,arr[a]=++j);
			}
		}
		return max;
	}

}
