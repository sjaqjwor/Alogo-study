import java.util.HashMap;
import java.util.Map;

public class KakaoCompassion {

    public static void main(String[] args) {
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
    }
    static int[] solution(String msg) {
        int[] answer = {};

        Map<String,Integer> map = new HashMap<>();
        for(int a=1;a<=26;a++){
            map.put(String.valueOf((char)(a+64)),a);
        }

        String m[] = msg.split("");
        StringBuilder sb=new StringBuilder();
        int check = 27;
        for(int a=0;a<msg.length();a++){
            String temp =String.valueOf(msg.charAt(a));
            String tmn = temp;
            if(map.containsKey(temp)){
                for(int b=a+1;b<msg.length();b++){
                    tmn+=String.valueOf(msg.charAt(b));
                    if(!map.containsKey(tmn)){
                        map.put(tmn,check++);
                        tmn=tmn.substring(0,tmn.length()-1);
                        break;
                    }else{
                        a++;
                    }
                }
            }
            sb.append(map.get(tmn)).append(" ");

        }
        String an[] = sb.toString().split(" ");
        answer = new int[an.length];
        int a=0;
        for(String t : an){
            answer[a]=Integer.parseInt(t);
            a++;
        }

        return answer;
    }
}
