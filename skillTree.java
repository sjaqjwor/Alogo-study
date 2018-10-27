import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class skillTree {

    public static void main(String[] args) {
        solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }

    static int solution(String skill, String[] skill_trees) {
        Pattern p = Pattern.compile(skill);
        int count =0;
        String regex = "[^"+skill+"]";
        for(String k : skill_trees){
           String str =  k.replaceAll(regex,"");
           count++;
           for(int a=0;a<str.length();a++){
               if(str.charAt(a)!= skill.charAt(a)){
                   count--;
                   break;
               }
           }
        }
        System.out.print(count);
        return count;
    }
}

