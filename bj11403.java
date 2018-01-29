package baeckjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj11403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int nu = sc.nextInt();
			int arr[][] = new int[nu][nu];
			ArrayList<Integer>[] list = new ArrayList[nu];
			boolean check[] = new boolean[nu];
			
			
			for(int a=0;a<nu;a++) {
				list[a]= new ArrayList<>();
			}
			for(int a=0;a<nu;a++) {
				for(int a1=0;a1<nu;a1++) {
					int num=sc.nextInt();
					if(num==1) {
						list[a].add(a1);
					}
				}
			}
			
			for(int a=0;a<nu;a++) {
				for(int a1=0;a1<list[a].size();a1++) {
					dfs(a,check,list,arr);
				}
				for(int a1=0;a1<nu;a1++) {
					if(check[a1]==true) {
						arr[a][a1]=1;
					}
				}
				Arrays.fill(check, false);
			}
			for(int a=0;a<nu;a++) {
				for(int a1=0;a1<nu;a1++) {
					System.out.print(arr[a][a1]+" ");
				}
				System.out.println();
			}
			
			
	}
	static void dfs(int nu, boolean check[],List[] list,int arr[][]) {
		for(int a=0;a<list[nu].size();a++) {
			if(!check[(int)list[nu].get(a)]) {
				check[(int)list[nu].get(a)]=true;
				arr[nu][(int)list[nu].get(a)]=1;
				dfs((int)list[nu].get(a),check,list,arr);
			}
		}
	}

}
