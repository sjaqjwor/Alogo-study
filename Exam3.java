import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exam3 {
    public static void main(String[] args) {

        System.out.print(solution("abcd","abcd",-5));
    }
    static String solution(String encrypted_text, String key, int rotation) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        encrypted_text=encrypted_text.toLowerCase();
        key=key.toLowerCase();
        Map<String,Integer> map = new HashMap<>();
        int cN = 97;
        for(int a=1;a<=26;a++){
            map.put(String.valueOf((char)cN),a);
            cN++;
        }
        char arr [] = new char[key.length()];

        if(rotation>0){
            if(rotation>encrypted_text.length()){
                rotation=rotation%encrypted_text.length();
            }
            for(int a=0;a<arr.length;a++){
                arr[(arr.length+(a-rotation))%arr.length]=encrypted_text.charAt(a);
            }
        }else{
            rotation=rotation*-1;
            for(int a=0;a<arr.length;a++){
                arr[(a+rotation)%arr.length]=encrypted_text.charAt(a);
            }
        }

        for(int a=0;a<key.length();a++){
            char ch = key.charAt(a);
            int chNum= map.get(String.valueOf(ch));
            int enNum = (int)arr[a];
            if(enNum-chNum<97){
                chNum=123-(97-(enNum-chNum));
            }else{
                chNum=enNum-chNum ;
            }
            ch=(char)chNum;
            sb.append(ch);
        }

        return sb.toString();
    }
}
