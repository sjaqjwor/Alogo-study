import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Password {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String num = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!num.equals("")){
            sb = new StringBuilder();
            String ti = br.readLine();
            String temp[] = ti.split(" ");
            int arr[]  = new int[temp.length];
            int count=0;
            for(String str : temp){
                arr[count]=Integer.parseInt(str);
            }
            Arrays.sort(arr);
            int min = (arr[0]/15)*15;
            for(int a=0;a<temp.length;a++){
                temp[a]=String.valueOf(Integer.parseInt(temp[a])-min);
            }
            int a=0;
            int n=1;
            int size= temp.length;
            while(Integer.parseInt(temp[a])-n >=1){
                temp[a]=String.valueOf(Integer.parseInt(temp[a])-n);
                a++;
                n++;
                if(a>=size){
                    a=0;
                }
                if(n==6){
                    n=1;
                }
            }
            temp[a]=String.valueOf(0);
            sb.append("#").append(num).append(" ");
            int tempa = a+1;
            while(tempa!=a){
                if(tempa>=size){
                    tempa=0;
                }
                if(tempa==a){
                    break;
                }
                sb.append(temp[tempa]).append(" ");
                tempa++;

            }
            sb.append(temp[a]);
            System.out.println(sb.toString());
            num = br.readLine();

        }

    }
}
