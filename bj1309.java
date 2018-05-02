package baeckjoon;

import java.util.Scanner;

public class bj1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] dist = new long[n+1];
         
        dist[0] = 1;
        dist[1] = 3;
        for(int i=2; i<dist.length; i++){
            dist[i] = (dist[i-2]+dist[i-1]*2)%9901;
        }
         
        System.out.println(dist[n]);
	}

}
