import java.util.HashMap;
import java.util.Map;

public class WinterCoding {
    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE","CBADF","AECB","BDA"}));
    }
   static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String p = "[^"+skill+"]";
        for(String k : skill_trees){
            String temp = k.replaceAll(p,"");
            answer++;
            for(int a=0;a<temp.length();a++){
                if(skill.charAt(a)!=temp.charAt(a)){
                    answer--;
                    break;
                }

            }
        }
        return answer;
    }
}
