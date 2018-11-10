import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class st11Test2 {
    public static void main(String[] args) {
        String k = "Forget  Cvs.. Save time a! . x x";
//        String k = "we test coders. give us a try?";
//        String k = "a?ab?c.";
        int count = Integer.MIN_VALUE;
//
//        Optional<Integer> an =Arrays.stream(k.split("[.!?]")).map(s ->
//        {
//            String p[]=  s.split(" ");
//            int num=0;
//            for(String k2 : p){
//                if(k2.length()>0){
//                    num+=1;
//                }
//            }
//            return num;
//        }).sorted(Comparator.reverseOrder()).findFirst();
//        System.out.println(an.get());



        String str[] = k.split("[.!?]");
        for(String k1 : str){
            System.out.println(k1);
            String p[]=  k1.split(" ");
            int num=0;
            for(String k2 : p){
                System.out.println(k2);
                if(k2.length()>0){
                    num+=1;
                }
            }
            if(count<num){
                count=num;
            }
        }
        System.out.println(count);

    }
}
