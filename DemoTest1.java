import java.util.HashMap;
import java.util.Map;

public class DemoTest1 {

    public static void main(String[] args) {
      int arr[] =  solution(new int[][]{{1, 4}, {3, 4}, {3, 10}});
      System.out.println(arr[0]+" "+arr[1]);
    }
    static int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<String,Integer> map = new HashMap<>();

        String b1="x";
        for(int a=0;a<v.length;a++){
            b1="x";
            for(int b=0;b <v[a].length;b++) {
                map.merge(v[a][b]+b1,1,Integer::sum);
                b1="y";
            }
        }

        for(Map.Entry m : map.entrySet()){
            if((int)m.getValue()%2!=0){
                if(((String)m.getKey()).charAt(((String) m.getKey()).length()-1)=='x'){
                    String temp = ((String) m.getKey());
                    temp=temp.replace("x","");
                    answer[0]=Integer.parseInt(temp);
                }else{
                    String temp = ((String) m.getKey());
                    temp=temp.replace("y","");
                    answer[1]=Integer.parseInt(temp);
                }
            }
        }

        return answer;
    }
}
