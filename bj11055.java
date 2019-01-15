
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        list.forEach(s -> System.out.print(s));


        int n = sc.nextInt();

        int arr[] = new int[n];
        int su[] = new int[n];


        for(int a=0;a<n;a++){
            arr[a]=sc.nextInt();
            su[a]=arr[a];
        }

        for(int a=0;a<n;a++){
            for(int b=0;b<a;b++){
                if(arr[b]<arr[a]){
                    su[a]=Math.max(su[a],arr[a]+su[b]);
                }
            }
        }

        int max=0;
       for(int k : su){
           if(k>max){
               max=k;
           }
       }
       System.out.print(max);
    }
}
