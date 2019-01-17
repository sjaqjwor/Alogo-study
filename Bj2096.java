import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bj2096 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int d[][] = new int[num+1][3];
        int arr[][] = new int[num+1][3];
        StringBuilder sb = new StringBuilder();
        for(int a=0;a<num;a++){
            for(int b=0;b<num;b++){
                arr[a+1][b]=sc.nextInt();
            }
        }

        for(int a=1;a<=num;a++){
            d[a][0]=Math.max(d[a-1][1],d[a-1][0])+arr[a][0];
            d[a][1]=Math.max(Math.max(d[a-1][1],d[a-1][0]),d[a-1][2])+arr[a][1];
            d[a][2]=Math.max(d[a-1][1],d[a-1][2])+arr[a][2];
        }

        sb.append(Math.max(Math.max(d[num][0],d[num][1]),d[num][2])).append(" ");

        for(int a=0;a<=num;a++){
            Arrays.fill(d[a],0);
        }
        for(int a=1;a<=num;a++){
            d[a][0]=Math.min(d[a-1][1],d[a-1][0])+arr[a][0];
            d[a][1]=Math.min(Math.min(d[a-1][1],d[a-1][0]),d[a-1][2])+arr[a][1];
            d[a][2]=Math.min(d[a-1][1],d[a-1][2])+arr[a][2];
        }

        sb.append(Math.min(Math.min(d[num][0],d[num][1]),d[num][2]));
        System.out.print(sb.toString());
    }
}
