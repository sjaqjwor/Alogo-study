import java.util.Arrays;

public class MoveString {

    public static void main(String[] args) {
        System.out.println(move("abcdef",1,0));
    }

    static String move(String s , int left , int right){

        if(right<left){
            int num = left-right;
            num = num%s.length();

            char k [] = s.toCharArray();
            char an [] = new char[k.length];

            for(int a=0;a<k.length;a++){
                if(a-num < 0 ){
                    an[k.length+(a-num)]=k[a];
                }else{
                    an[a-num]= k[a];
                }
            }
            return Arrays.toString(an);
        }else  if(right>left){
            int num = right-left;
            num = num%s.length();

            char k [] = s.toCharArray();
            char an [] = new char[k.length];

            for(int a=0;a<k.length;a++){
                if(a+num > k.length-1){
                    an[k.length-(a+num)]=k[a];
                }else{
                    an[a+num]= k[a];
                }
            }
            return Arrays.toString(an);
        }else{
            return s;
        }

    }
}
