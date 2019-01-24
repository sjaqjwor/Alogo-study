import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sw_2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        boolean b1[][]=null;
        for(int a=0;a<num;a++){
            int size = Integer.parseInt(br.readLine());
            int arr[][] = new int [size][size];
            b1 = new boolean[size][size];
            int mid = size/2;

            for(int b=0;b<size;b++){
                String str[] = br.readLine().split("");
                for(int c=0;c<size;c++){
                    arr[b][c]=Integer.parseInt(str[c]);
                }
            }
            int sizeL = size/2+1;
            int result=0;
            for(int b=0;b<size/2;b++){
                for(int c = size-(sizeL+b);c<=size-(sizeL-b);c++){
                    result+=arr[b][c];
                }
            }
            for(int b=size/2+1;b<size;b++){
                for(int c = (sizeL+b)-size;c<=size-(b-size/2)-1;c++){
                    result+=arr[b][c];
                }
            }

            for(int b=0;b<size;b++){
                result+=arr[size/2][b];
            }

            sb.append("#").append(a+1).append(" ").append(result);
            System.out.println(sb.toString());
            sb=new StringBuilder();
        }
    }
}
