public class SummercodingJump {

    public static void main(String[] args) {
            solution(5000);
    }
    static int solution(int n) {
        int ans = 0;

        int arr[] = new int[n+1];

        arr[1]=1;

        for(int a=2;a<=n;a++){
            if(a%2==0){
                arr[a]=Math.min(arr[a-1]+1,Math.min(a,arr[a/2]));
            }else{
                arr[a]=Math.min(arr[a-1]+1,a);
            }
        }

        ans=arr[n];

        return ans;
    }
    static  int Success(int n){

        int an=0;
        while(true){
            if(n==0){
                break;
            }
            if(n%2==1){
                n=n-1;
                an++;
            }
        }
        return an;
    }
}
