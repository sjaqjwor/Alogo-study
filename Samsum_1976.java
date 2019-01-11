import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Samsum_1976  {

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for(int a=0;a<num;a++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int bh = Integer.parseInt(st.nextToken());
            int bm = Integer.parseInt(st.nextToken());

            int ah = Integer.parseInt(st.nextToken());
            int am = Integer.parseInt(st.nextToken());

            int tempH = bh+ah;
            int tempM = bm+am;

            if(tempM>59){
                tempH++;
                tempM-=59;
            }
            if(tempH>12){
                tempH-=12;
            }
            sb.append("#").append(num+1).append(" ").append(tempH).append(" ").append(tempM);
            System.out.println(sb.toString());
        }


    }
}
