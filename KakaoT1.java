import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KakaoT1 {

    public static void main(String[] args) {
       System.out.println( solution("+82-010-3444-2323"));
        solution("01012345678");

    }

    static int solution(String PhoneNumber){
        String regex3 = "(\\+82-10-[0-9]{4}-[0-9]{4})";
        String regex2= "(010-[0-9]{4}-[0-9]{4})";
        String regex1 = "(010[0-9]{4}[0-9]{4})";
        String [] str = new String[]{regex1,regex2,regex3};
        for(int a=0;a<3;a++){
            Pattern pattern = Pattern.compile(str[a]);
            Matcher m = pattern.matcher(PhoneNumber);
            if(m.matches()){
                return a+1;
            }
        }
        return -1;
    }
}
