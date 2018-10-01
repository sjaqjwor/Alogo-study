public class ProgrammersTileNasun {

    public static void main(String[] args) {
        long answer  = solution(7);
        System.out.println(answer);
    }
    static long solution(int N) {
        long answer = 0;
        long arr [] = new long[N+1];
        arr[1]=1;
        arr[2]=1;
        for(int a=3;a<=N;a++){
            arr[a]=arr[a-1]+arr[a-2];
        }
        if(N%2!=0){
            long height = arr[N];
            long width = arr[N]+arr[N-2]+arr[N-3];
            answer=height*2+width*2;
        }else {
            long width = arr[N];
            long height = arr[N]+arr[N-2]+arr[N-3];
            answer=height*2+width*2;

        }
        return answer;
    }
}
