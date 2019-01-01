import java.io.BufferedReader;
import java.io.InputStreamReader;

public class coupang3 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String temp = input.replaceAll("[\\{ \\} \\' \\']","");
        String arr[] = temp.split(",");;
        StringBuilder sb = new StringBuilder();


        for(int a=0;a<arr.length;a++){
            sb.append(arr[a]).append("\n");
            String word ="";
            word+=arr[a];
            for(int b=a+1;b<arr.length;b++){
                word+=arr[b];
                sb.append(word).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
