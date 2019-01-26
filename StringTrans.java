import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringTrans {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int k=0;k<num;k++){
            String temp[] = br.readLine().split(" ");
            System.out.println(solution(temp[0],temp[1]));
        }
        br.close();

    }
    static int solution(String A , String B){
        if(A.length()!=B.length()){
            return -1;
        }else{
            int arr[] = new int[A.length()];
            int brr[] = new int[B.length()];

            int b=0;
            int a=0;

            for(int c=0;c<A.length();c++){
                if(A.charAt(c)=='a'){
                    arr[a++]=c;
                }
                if(B.charAt(c)=='a'){
                    brr[b++]=c;
                }
            }

            int result=0;
            for(int c=0;c<A.length();c++){
                result+=arr[c]-brr[c] >=0 ? arr[c]-brr[c] : brr[c]-arr[c];
            }
            return result;

        }
    }
}
