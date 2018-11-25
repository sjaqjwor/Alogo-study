import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        System.out.print(solution(6000,7000));
    }

    static int solution(int A , int B){
        int max = 0;
       for(int a=2;a<A;a++){
           double temp = a;
           int count=0;
           while(Math.pow(temp,2) <= B){
               temp=Math.pow(temp,2);
               count++;
           }
           if(temp>=A && temp<=B && max<count){
               max=count;
           }
       }
       return max;
    }
}
