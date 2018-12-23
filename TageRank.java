import java.util.*;

public class TageRank {

    public static void main(String[] args) {
//        String str = "3+[(5+1)-1]";
//        String str = "3+([5+1])";
//        String str = "3+{(5+1}";
        String str = "3+[{(5+1)-1}+3]";
        String regex = "[^\\[ | \\] | \\{ | \\} | \\( | \\)]";
        String str1=str.replaceAll(regex,"");
        Stack<String> deque = new Stack<String>();
        Map<String,String> map = new HashMap<>();
        map.put("[","]");
        map.put("{","}");
        map.put("(",")");

        boolean check = true;
        System.out.println(str1);
       for(int a=0;a<str1.length();a++){
           if(deque.isEmpty()){
               deque.add(String.valueOf(str1.charAt(a)));
               continue;
           }
           if(map.get(deque.peek()).equals(String.valueOf(str1.charAt(a)))){
               deque.pop();
               continue;
           }
           if(deque.peek().equals("[") && (String.valueOf(str1.charAt(a)).equals("{") || String.valueOf(str1.charAt(a)).equals("(")) ){
               deque.add(String.valueOf(str1.charAt(a)));
           } else if(deque.peek().equals("{") && (String.valueOf(str1.charAt(a)).equals("(") ) ){
               deque.add(String.valueOf(str1.charAt(a)));

           }else{
               check=false;
               break;
           }
       }
       if(!deque.isEmpty() || check==false){
           System.out.println(check);
       }else{
           System.out.println(check);
       }



    }
}
