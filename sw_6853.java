import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_6853 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int a=0;a<num;a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
           sb = new StringBuilder();

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int test = Integer.parseInt(br.readLine());

            int result1=0,result2=0,result3=0;
            for(int b=0;b<test;b++){
                st = new StringTokenizer(br.readLine());
                int tempx = Integer.parseInt(st.nextToken());
                int tempy = Integer.parseInt(st.nextToken());

                if(tempx<=x1 && tempx>=x && tempy<=y1 && tempy>=y){
                    if(tempx==x || tempx==x1 || tempy == y1 || tempy ==y){
                        result1++;
                    }else{
                        result2++;
                    }
                }else{
                    result3++;
                }
            }
            sb.append("#").append(a+1).append(" "+result2).append(" "+result1).append(" "+result3);

        }
        System.out.println(sb.toString());

    }
}
