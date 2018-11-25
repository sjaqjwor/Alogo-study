import java.util.*;

public class CompareString {

    public static void main(String[] args) {

        System.out.print(solution("o","odd"));
    }
    static String solution(String a, String k){

        List<String> list = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        if(a.length()-k.length() >=2 || k.length()-a.length()>=2){
            return "불가능";
        }
        if(a.equals(k)){
            return "Nothing";
        }else if(k.length()==a.length()){
            int count=0;
            for(int b=0;b<a.length();b++){
                if(a.charAt(b)!=k.charAt(b)){
                    count++;
                    st.append(a.charAt(b)).append(" ");
                }
            }
            if(count>2){
                return "불가능";
            }else{
                return st.insert(0,"swap").toString();
            }

        }else{
                Map<String,Integer> map  = new HashMap<>();
               for(int b=0;b<a.length();b++){
                   map.merge(String.valueOf(a.charAt(b)),1,Integer::sum);
               }

                for(int b=0;b<k.length();b++){
                    if(map.containsKey(String.valueOf(k.charAt(b)))){
                        int num = map.get(String.valueOf(k.charAt(b)));
                        if(num-1==0){
                            map.remove(String.valueOf(k.charAt(b)));
                        }else{
                            map.put(String.valueOf(k.charAt(b)),num-1);
                        }
                    }else{
                        map.put(String.valueOf(k.charAt(b)),1);
                    }
                }

                int count=0;

                for(Map.Entry map1 : map.entrySet()){
                    count++;
                    st.append(map1.getKey()).append(" ");
                }
                if(count>2){
                    return "불가능";
                }else{
                    if(k.length()>a.length()){
                        st.insert(0,"insert");
                    }else{
                        st.insert(0,"delete");
                    }
                    return st.toString();
                }
        }
    }
}
