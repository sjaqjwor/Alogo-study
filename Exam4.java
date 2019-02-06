public class Exam4 {
    public static void main(String[] args) {
        System.out.print(solution2(10));
    }
    static long solution(long k) {
        long num=1;
        long anNum=1;
        boolean check=false;
        long answer=0;
        while(!check){
            for(long a=1;a<=num;a++){
               if(anNum==k){
                   check=true;
                   answer=a;
               }
                anNum++;
            }
            num++;
        }
        return answer;
    }

    static long solution2(long k){
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
