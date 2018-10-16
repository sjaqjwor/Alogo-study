import java.util.*;

public class KakaoTest1 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        LinkedList<String> list = new LinkedList<>();
        solution(record);
    }
    static String[] solution(String[] record){
        Map<String , String> map =  new HashMap<>();

        for(String str : record){
            String temp[] = str.split(" ");

            if(temp[0].equals("Enter") || temp[0].equals("Change")){
                map.put(temp[1],temp[2]);
            }
        }
        StringBuilder st = new StringBuilder();
        for(String str : record){
            String temp[] = str.split(" ");

            if(temp[0].equals("Enter") ){
                st.append(map.get(temp[1])+"님이 들어왔습니다.").append("\n");
            }

            if(temp[0].equals("Leave") ){
                st.append(map.get(temp[1])+"님이 나갔습니다.").append("\n");
            }
        }
        String []str = st.toString().split("\n");

        return str;
    }
}
