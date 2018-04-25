package baeckjoon;

import java.util.Scanner;

public class bj9633 {
	static int count=0;
	static int v=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		int arr[] = new int[v+1];
		for(int a=1;a<=v;a++) {
			//a 열
			arr[1]=a;
			qu(arr,1);
		}
		System.out.println(count);
		
	}
	static void qu(int arr[],int num) {
		if(v==num) {
			count++;
		}else {
			for(int a=1;a<=v;a++) {
				arr[num+1]=a;
				if(check(arr,num+1)) {
					qu(arr,num+1);
				}
			}
		}
	}
	static boolean check(int arr[],int num) {
		for(int b=1;b<num;b++) {
			if(arr[b]==arr[num]) {
				return false;
			}
			if(Math.abs(arr[b]-arr[num])==Math.abs(b-num)) {
				return false;
			};
		}
		return true;
	}

}
