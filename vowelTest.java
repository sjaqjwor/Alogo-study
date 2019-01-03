import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class vowelTest {

    public static void main(String[] args) {
        String reges = "(^[^aeiou]*[aeiou]{2}[^aeiou]*$)";
        String reges1 = "(^[aeiou]*[^aeiou]{3}[aeiou]*$)";
        String arr []  = new String[]{"toast","standard","bank","display","book"};
        Pattern p = Pattern.compile(reges);
        Pattern p1 = Pattern.compile(reges1);

        int count =0;
        int count1 =0;
        for(String k : arr){
            Matcher m = p.matcher(k);
            Matcher m1 = p1.matcher(k);
            boolean check1 = m.find();
            boolean check2 = m1.find();
            if(check1 && check2){
                count++;
                count1++;
            }else if(check1){
                count++;
            }else if(check2){
                count1++;
            }
        }

        System.out.print(count+" "+count1);
    }
}
