
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectYear {

    public static void main(String[] args) throws Exception {

        String str = "2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.";
        String str2 = "타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일";
        String str3 = "배민은행앞 별다방에서 18-06-12에 만나기로함";


        String [] arr= new String[]{str,str2,str3};
        Pattern datePattern = Pattern.compile("([0-9]{4}||[0-9]{2})[-/년]([0-9]{1,2})[-/월]([0-9]{1,2})[일]*");
        List<StringOdYear> list = new ArrayList<>();
        for(String k : arr){
            Matcher dateMacher = datePattern.matcher(k);
           String date = "";
            while(dateMacher.find()){
                date+= dateMacher.group(1).length() > 2 ? dateMacher.group(1) : "20"+dateMacher.group(1);
                date+= dateMacher.group(2).length() > 1 ? dateMacher.group(2) : "0"+dateMacher.group(2);
                date+= dateMacher.group(3).length() > 1 ? dateMacher.group(3) : "0"+dateMacher.group(3);
            }
           list.add(new StringOdYear(k,Integer.parseInt(date)));
        }
        Collections.sort(list);
        list.forEach(s-> System.out.println(s.text));

    }
}
class StringOdYear implements Comparable<StringOdYear> {
    String text;
    int yaer;


    public StringOdYear(String text, int year) {
        this.text = text;
        this.yaer = year;
    }

    @Override
    public int compareTo(StringOdYear o) {
        if (this.yaer > o.yaer) {
            return 1;
        } else if (this.yaer < o.yaer) {
            return -1;
        } else {
            return 0;
        }
    }
}
