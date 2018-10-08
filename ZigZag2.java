import java.io.BufferedWriter;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class ZigZag2 {

    public static void main(String[] args) {
        int n =2015;



        Set<String> set = new HashSet<>();
        boolean check = false;
        for(int a=n+1;a<10000;a++){
            String num = String.valueOf(a);
            for(int b=0;b<num.length();b++){
                if(set.contains(String.valueOf(num.charAt(b)))){
                    check=false;
                    break;
                }else{
                    set.add(String.valueOf(num.charAt(b)));
                    check=true;
                }
            }
            set=new HashSet<>();
            if(check){
                System.out.println(num);
                break;
            }
        }
    }
}
