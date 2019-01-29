import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KakaoBeforeMusic {


    public static void main(String[] args) {

        //System.out.println(solution2("C#B#",new String[]{"13:00,13:05,WORLD,ABCDEF","12:00,12:14,HELLO,CDEFGAB"}));
        System.out.println(solution2("CC#BCC#BCC#BCC#B",new String[]{"04:00,04:50,BAR,CC#BCC#BCC#B","03:00,03:50,FOO,CC#B","01:40,02:20,B22A,CC#BCC#BCC#B","02:00,02:50,B2A,CC#BCC#BCC#B"}));
        //System.out.println(solution2("ABC",new String[]{"12:00,12:14,HELLO,C#DEFGAB","13:00,13:05,WORLD,ABCDEF"}));
    }
    static String solution2(String m, String[] musicinfos) {
        String answer = "";

        List<String> list = Arrays.asList(musicinfos);
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int m1time = (Integer.parseInt(o1.substring(6,8))*60+Integer.parseInt(o1.substring(9,11)))-(Integer.parseInt(o1.substring(0,2))*60+Integer.parseInt(o1.substring(3,5)));
                int m2btime = (Integer.parseInt(o2.substring(6,8))*60+Integer.parseInt(o2.substring(9,11)))-(Integer.parseInt(o2.substring(0,2))*60+Integer.parseInt(o2.substring(3,5)));
                return m1time-m2btime;
            }
        });
        list.forEach(System.out::println);

        for(String str : list){
           StringBuilder sb= new StringBuilder();
            String temp[] = str.split(",");
            int startTime =Integer.parseInt(temp[0].substring(0,2))*60+Integer.parseInt(temp[0].substring(3,5));
            int end = Integer.parseInt(temp[1].substring(0,2))*60+Integer.parseInt(temp[1].substring(3,5));
            int time =Math.abs(startTime-end);
            String word="";
            word=temp[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a");

            int j=0;
            for(int i = 0; i < time ; i++) {
                j = i % word.length();
                sb.append(word.charAt(j));
            }
            if(sb.toString().contains(m)){
                answer+=temp[2];
                break;
            }

        }
        return answer.equals("") ? "'(None)'" : answer;
    }
}
