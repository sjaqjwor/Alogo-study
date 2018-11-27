import java.util.Arrays;

public class SchoolLoad {

    public static void main(String[] args) {
        solution(4,3,new int[][]{{2,2}});
    }
    static int solution(int m, int n, int[][] puddles) {
        int arr[][] = new int[n+1][m+1];
        int d[][] = new int[n+1][m+1];

        for(int a=0;a<puddles.length;a++){
            arr[puddles[a][0]][puddles[a][1]]=-1;
        }
        d[1][0]=1;
        for(int a=1;a<=n;a++){
            for(int b=1;b<=m;b++){
                if(arr[a][b]==-1){
                    d[a][b]=0;
                }else{
                    d[a][b]=(d[a-1][b]+d[a][b-1])%1000000007;
                }
            }
        }

        return d[n][m];
    }

}
