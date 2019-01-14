public class Studytest02 {

    public static void main(String[] args) {
        System.out.print(solution(6));
    }
    static long solution(long k){
        long sum=1;
        long num=1;
        do{
            num += sum;
            sum++;
        }while (num<=k);

        sum=sum-1;
        num-=sum;
        return (k-num)+1;
    }
}
