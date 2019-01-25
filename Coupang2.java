import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Coupang2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        while (!line.equals("")){
            sb.append(line).append(" ");
            line=br.readLine();
        }
        Map<String,Integer> search = new HashMap<>();
        Map<String, List<String>> wordSearch = new HashMap<>();
        Map<String, Boolean> check = new HashMap<>();
        System.out.print(check.get("tr"));

        String temp [] = sb.toString().split(" ");
        int searchNum = Integer.valueOf(temp[0]);
        for(int a=1;a<=searchNum;a++){
            String t[] = temp[a].split(",");
            search.put(t[0],Integer.valueOf(t[1]));
        }
        int wordNum = Integer.valueOf(temp[searchNum+1]);


        sb = new StringBuilder();

       for(int a=(wordNum+searchNum)-1; a<temp.length;a++) {
           String t[] = temp[a].split(",");
           if (wordSearch.containsKey(t[0])) {
               List<String> list = wordSearch.get(t[0]);
               for (int b = 1; b < t.length; b++) {
                   list.add(t[b]);
               }

               wordSearch.put(t[0],list);
           } else {
               List<String> list = new ArrayList<>();
               for (int b = 1; b < t.length; b++) {
                   list.add(t[b]);
               }

               wordSearch.put(t[0],list);
           }
       }
        for(int a=1;a<=searchNum;a++){
            String t[] = temp[a].split(",");
            String w=t[0];
            String maxWord="";
            int sum=0;
            while(w!=null && (check.get(w)==null || check.get(w)!=true) ){
                List<String> list = wordSearch.get(w);
                check.put(w,true);
                int max=0;
                for(String p : list){
                    if(search.get(p)>max){
                        maxWord=p;
                    }
                    sum+=search.get(p);

                    check.put(p,true);
                }
                sb.append(maxWord).append(",").append(sum);
            }

        }

       System.out.print(sb.toString());

    }
}
