import java.util.HashMap;
import java.util.Map;

public class CompareTime {

    public static void main(String[] args) {

        System.out.print(solution("22:22:21","22:22:23"));
    }
    static int solution(String k, String p){
        String ktime[] = k.split(":");
        String ptime[] = p.split(":");
        int answer=0;

        Integer kt = Integer.parseInt(ktime[0])*3600+Integer.parseInt(ktime[1])*60+Integer.parseInt(ktime[2]);

        Integer pt = Integer.parseInt(ptime[0])*3600+Integer.parseInt(ptime[1])*60+Integer.parseInt(ptime[2]);
        if(kt>pt){

            for(int a= pt;a<=kt;a++){
                int temp= a;
                int sec = temp%60;
                temp/=60;
                int min =temp%60;
                temp/=60;
                int hour = temp;
                String time = "";
                if(hour<10){
                    time+="0"+String.valueOf(hour);
                }else{

                    time+=String.valueOf(hour);
                }
                if(min<10){
                    time+="0"+String.valueOf(min);
                }else{
                    time+=String.valueOf(min);
                }
                if(sec<10){
                    time+="0"+String.valueOf(sec);
                }else{
                    time+=String.valueOf(sec);
                }
                System.out.print(time);
                Map<String , Integer> map  = new HashMap<>();
                for(int b=0;b<time.length();b++){
                    map.merge(String.valueOf(time.charAt(b)),1,Integer::sum);
                }

                int count=0;
                for(Map.Entry m : map.entrySet()){
                    count++;
                }

                if(count<=2){
                    answer++;
                }
            }
            return answer;
        }else{
            for(int a= kt;a<=pt;a++){
                int temp= a;
                int sec = temp%60;
                temp/=60;
                int min =temp%60;
                temp/=60;
                int hour = temp;
                String time = "";
                if(hour<10){
                    time+="0"+String.valueOf(hour);
                }else{

                    time+=String.valueOf(hour);
                }
                if(min<10){
                    time+="0"+String.valueOf(min);
                }else{
                    time+=String.valueOf(min);
                }
                if(sec<10){
                    time+="0"+String.valueOf(sec);
                }else{
                    time+=String.valueOf(sec);
                }
                Map<String , Integer> map  = new HashMap<>();
                for(int b=0;b<time.length();b++){
                    map.merge(String.valueOf(time.charAt(b)),1,Integer::sum);
                }


                int count=0;
                for(Map.Entry m : map.entrySet()){
                    count++;
                }

                if(count<=2){
                    answer++;
                }
            }
            return answer;
        }
    }
}
