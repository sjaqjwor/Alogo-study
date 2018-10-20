import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KakaoPre {

    public static void main(String[] args) {



        String[] str = {
                "unicom6.unicomp.net - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/ HTTP/1.0\" 200 3985",
                "burger.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.html HTTP/1.0\" 200 3985",
                "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.gif HTTP/1.0\" 304 3985",
                "burget.letters.com - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/contdown/liftoff.gif HTTP/1.0\" 200 3985"};

        List<String> list = new ArrayList<>();
        for(String k : str){
            String temp[] = k.split(" ");
            if(temp[temp.length-2].equals("200") && temp[temp.length-4].contains(".gif")){
                int index = temp[temp.length-4].lastIndexOf("/");
                int lastindex = temp[temp.length-4].length();
                String img = temp[temp.length-4].substring(index+1,lastindex);
                list.add(img);
            }
        }
        list.forEach(System.out::println);
    }
}
