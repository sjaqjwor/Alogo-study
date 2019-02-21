import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1; i++) {

            int ts = sc.nextInt();
            int arr [] = new int[ts];
            for (int j = 0; j < ts; j++) {
                arr[j] = sc.nextInt();
            }

            int result = solution(arr);
            System.out.println("#"+i+" "+result);


        }
    }
    static int solution(int arr[]){
        int result=0;
        int dx[]= new int[]{-2,-1,1,2};
        for(int a=0;a<arr.length;a++){
            int max=0;
            if(arr[a]==0){
                continue;
            }
            for(int b=0;b<4;b++){
                if(a+dx[b]<0 || a+dx[b]>arr.length-1){
                    continue;
                }
                if(arr[a+dx[b]]==0 ){
                    continue;
                }else if(arr[a+dx[b]]<arr[a]){
                    if(max<arr[a+dx[b]]){
                        max=arr[a+dx[b]];
                    }
                }else{
                    max=0;
                    break;
                }
            }
            if(max==0){
                max=0;
            }else{
                max=arr[a]-max;
            }
            result+=max;
        }
        return result;
    }

}
