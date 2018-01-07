package baeckjoon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj1202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			Jewerly j[] = new Jewerly[n];
			int b[] = new int [m];
			
			for(int a=0;a<n;a++) {
				int b1 =sc.nextInt();
				int c = sc.nextInt();
				j[a] = new Jewerly(b1,c);
			}
			for(int a=0;a<m;a++) {
				b[a]=sc.nextInt();
			}
			Arrays.sort(j);
			
			
			
			int start=0;
			int min=0;
			for(int a=m-1;a>=0;a--) {
				if(j[start].weight<=b[a]) {
					min+=j[start].cost;
					start++;
				}
			}
			System.out.println(min);
			
			
	}

}
class Jewerly implements Comparable<Jewerly>{
	int weight;
	int cost;
	
	public Jewerly(int w, int c) {
		this.weight=w;
		this.cost=c;
	}

	@Override
	public int compareTo(Jewerly o) {
		// TODO Auto-generated method stub
		return this.cost-o.cost > 0 ? -1: 1;
	}
	
	
}
