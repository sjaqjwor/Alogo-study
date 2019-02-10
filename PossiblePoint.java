import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PossiblePoint {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb;
        for(int a=0;a<t;a++){
            sb=new StringBuilder();;
            int num = Integer.parseInt(br.readLine());
            int arr[] = new int[num];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum=0;
            for(int b=0;b<num;b++){
                arr[b]=Integer.parseInt(st.nextToken());
                sum+=arr[b];
            }
            boolean check[] = new boolean[sum+1];

            check[0]=true;
            for(int b=0;b<num;b++){
                for(int c=sum;c>=0;c--){
                    if(check[c]){
                        check[arr[b]+c]=true;
                    }
                }
            }

            int result=0;
            for(int b=0;b<check.length;b++){
                if(check[b]){
                    result++;
                }
            }
            sb.append("#").append(a+1).append(" ").append(result);
            System.out.println(sb.toString());
        }
    }
}
