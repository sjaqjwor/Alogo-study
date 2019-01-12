import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Coupang4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String str = input.replaceAll(",","");
        String temp[]= str.split(" ");

        Map<String,List<Integer>> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        for(int a=0;a<temp.length;a++){
            if(map.containsKey(temp[a])){
                List<Integer> list = map.get(temp[a]);
                list.add(a);
                map.put(temp[a],list);
            }else{
               List<Integer> list = new ArrayList<>();
               list.add(a);
                map.put(temp[a],list);
            }
        }
        for(Map.Entry m : map.entrySet()){
            List<Integer> list = (List<Integer>)m.getValue();

            if(list.size()>=2){
                for(int num : list){
                    sb.append(num).append(", ");
                }
            }
        }
        System.out.print(sb.toString().substring(0,sb.toString().length()-2));

    }
}
class W{
    int num;
    String word;
    public  W(int num,String word){
        this.num=num;
        this.word=word;
    }
}
