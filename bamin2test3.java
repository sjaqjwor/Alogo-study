package baeckjoon;

import java.util.Scanner;

public class bamin2test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner s = new Scanner(System.in)) {
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			int x3 = s.nextInt();
			int y3 = s.nextInt();
			int x4 = s.nextInt();
			int y4 = s.nextInt();
			int x5 = s.nextInt();
			int y5 = s.nextInt();
			int x6 = s.nextInt();
			int y6 = s.nextInt();
			int dx[] = new int[] { x1, x2, x3, x4, x5, x6 };
			int dy[] = new int[] { y1, y2, y3, y4, y5, y6 };
			int y = Math.max(Math.max(y1, Math.max(y2, y3)), Math.max(y4, Math.max(y5, y6)));
			int x = Math.max(Math.max(x1, Math.max(x2, x3)), Math.max(x4, Math.max(x5, x6)));
			int arr[][] = new int[y+1][x+1];
			boolean check[][] = new boolean[y+1][x+1];
			int count=1;
			int t=0;
			for (int a = 0; a <=4; a+=2) {
				for (int k1 = dy[a]; k1 < dy[a + 1]; k1++) {
					for (int k = dx[a]; k < dx[a + 1]; k++) {
						arr[k1][k]=count;
						
					}
				}
				count+=1;
			}
			
			int count1=0;
			for(int a=0;a<=y;a++) {
				for(int a1=0;a1<=x;a1++) {
					if(arr[a][a1]==1) {
						count1+=1;
					}
				}
			}
			System.out.println(count1);
		}
	}

}
