import java.util.HashSet;
import java.util.Set;

public class Zum4 {

    public static void main(String[] args) {
            solution("coddll");
    }
    static int solution(String S) {
        Set<String> set= new HashSet<>();

        int arr[][] = new int[S.length()][S.length()];

        int count=1;
        for(int a=0;a<S.length();a++){
            if(set.contains(String.valueOf(S.charAt(a)))){
                arr[0][a]=arr[0][a-2];
                count--;

            }
            else{
                arr[0][a]=count;
                set.add(String.valueOf(S.charAt(a)));
                count++;
            }

        }
        for(int a=1;a<S.length();a++){

            for(int b=a+1;b<S.length();b++){
                arr[a][a]=1;
                if(arr[a-1][b-1]<arr[a-1][b]){
                    arr[a][b]=arr[a][b-1]+1;
                }else if(arr[a-1][b-1]>arr[a-1][b]){
                        if(arr[a][b-2]==0){
                            arr[a][b]=arr[a][b-1]+1;
                        }else{
                            arr[a][b]=arr[a][b-2];
                        }

                }else{
                    arr[a][b]=arr[a][b-1];
                }
            }
        }
        for(int a=0;a<S.length();a++){
            for(int b=0;b<S.length();b++){
                System.out.print(arr[a][b]+" ");
            }
            System.out.println();
        }
        int sum=0;
        for(int a=0;a<S.length();a++){
            for(int b=0;b<S.length();b++){
                sum+=arr[a][b];
            }
        }
        System.out.print(sum+1);
       return 0;
    }
}
