public class ProgrammersTile {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    static int solution(int n) {
        int answer = 0;
        int arr[] = new int[n+1];
        arr[2]=2;
        arr[3]=3;
        for(int a=4;a<=n;a++){
            arr[a]=(arr[a-1]+arr[a-2])%1000000007;
        }
        answer = arr[n];
        return answer;
    }
}
