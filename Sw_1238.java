import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Sw_1238 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testSize = Integer.parseInt(br.readLine());


        for(int a=1;a<=testSize;a++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            List<Integer>[] list = new List[size+1];
            int arr[][] = new int [size+1][size+1];
            for(int b=0;b<=size;b++){
                list[b]=new ArrayList();
            }
            int dp[][] = new int[size+1][size+1];
            for(int b=1;b<=size;b++){
                for(int c=1;c<=size;c++){
                    if(Integer.parseInt(st.nextToken())==1){
                        list[b].add(c);
                        arr[b][c]=1;
                        dp[b][c]=1;
                    }else{
                        dp[b][c]=Integer.MAX_VALUE;
                    }
                }
            }
            boolean check[] = new boolean[size+1];
            Queue<Integer> queue = new LinkedList<>();

            for(int b=1;b<=size;b++){
                check[b]=true;
                queue.add(b);
                while(!queue.isEmpty()){
                    int num = queue.poll();

                    for(int c=0;c<list[num].size();c++){
                        int temp=list[num].get(c);
                        if(!check[temp]){
                            dp[b][temp]=Math.min(dp[b][temp],arr[num][temp]+arr[b][num]);
                            check[temp]=true;
                            queue.add(temp);
                        }
                    }
                }
                Arrays.fill(check,false);
            }
            int result=0;
            int max=Integer.MAX_VALUE;

            for(int b=1;b<=size ;b++){
                result=0;
                for(int c=1;c<=size;c++){
                    if(dp[b][c]!=Integer.MAX_VALUE){
                        result+=dp[b][c];
                    }
                }
               if(result<max){
                   max=result;
               }
            }

            sb.append("#").append(a).append(" ").append(max);
            System.out.println(sb.toString());
        }
    }
}
