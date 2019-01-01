import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Coupang1 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb= new StringBuilder();
        while (!line.equals("")){
            sb.append(line);
            line=br.readLine();
        }
        String str = sb.toString();
        String temp[] = str.replaceAll("[^A-Za-z\" \"]","").split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String word : temp){
            if(!word.equals("")){
                String tempa = String.valueOf(word.charAt(0));
                tempa+=String.valueOf(word.charAt(word.length()-1));
                map.merge(tempa.toLowerCase(),1,Integer::sum);
            }
        }
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator(){

            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v1).compareTo(v2);
            }

        });
        Collections.reverse(list);

        Iterator it =list.iterator();
        while(it.hasNext()){
            String k = (String) it.next();
            System.out.println(k + " = " + map.get(k));
        }

    }
}
