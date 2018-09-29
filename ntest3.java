import java.util.Scanner;

public class ntest3 {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int a=0;a<n;a++){
            arr[a]=sc.nextInt();
        }
        int max=0;
        int maxIndex=0;
        for(int a=0;a<n;a++){
            if(arr[a]>=max){
                max=arr[a];
                maxIndex=a;
            }
        }
        int startIndex=-1;
        int count=0;
        int buy=0;
        int get=0;

        while(startIndex + 1 < n-1){
            buy=0;
            count=0;
            for(int a=startIndex+1;a<maxIndex;a++){
                buy+=arr[a];
                count++;
            }
            startIndex=maxIndex;
            get+=(count*arr[maxIndex]-buy)-1;
            if (startIndex + 1 <= n - 1) {
                max=0;
                maxIndex=0;
                for(int a=startIndex+1;a<n;a++){
                    if(arr[a]>=max){
                        max=arr[a];
                        maxIndex=a;
                    }
                }
            }
        }
        System.out.println(get <0 ? 0 : get);
    }
}
