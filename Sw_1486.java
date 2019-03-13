import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_1486 {

    static  int max  = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testSize = Integer.parseInt(br.readLine());

        for(int a=1;a<=testSize;a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            String temp[] = br.readLine().split(" ");
            an(0,0,num,people-1,temp);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(a).append(" ").append(max);
            max=Integer.MAX_VALUE;
            System.out.println(sb.toString());

        }


    }
    static void an(int index, int sum ,int num,int people,String temp[]){

        if(sum>=num){
            max=Math.min(max,sum-num);
        }
        if(index>people)return;
        an(index+1,sum+Integer.parseInt(temp[index]),num,people,temp);
        an(index+1,sum,num,people,temp);


    }
}
