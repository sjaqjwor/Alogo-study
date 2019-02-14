import java.util.*;

public class WordTest {

    public static void main(String[] args) {

        System.out.println(solution("asf","akf"));
//        System.out.println(solution("anagram","MARGANA"));

    }
    static boolean solution(String a, String b) {
        boolean answer = true;
        a= a.toLowerCase();
        b=b.toLowerCase();
       if(a.length()!=b.length()){
           return !answer;
       }

       Map<String,Integer> map = new HashMap<>();

       String tempa[] = a.split("");
       for(String temp : tempa){
           map.merge(temp,1,Integer::sum);
       }

       tempa = b.split("");

       for(String temp : tempa){
           if(map.containsKey(temp) && map.get(temp)>0){
               map.put(temp,map.get(temp)-1);
           }else{
               return false;
           }
       }

        return answer;
    }
    static boolean solutionTwo(String a, String b){
        boolean answer = true;
        a=a.toLowerCase();
        b=b.toLowerCase();

        if(a.length()!=b.length()){
            return false;
        }
        String tempa[] = a.split("");
        String tempb[] = b.split("");
        Arrays.sort(tempa);
        Arrays.sort(tempb);

        int size = tempa.length;
        for(int A=0;A<size;A++){
            if(!tempa[A].equals(tempb[A])){
                answer=false;
                break;
            }
        }
        return answer;

    }
}
