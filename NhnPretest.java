import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class NhnPretest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String str[] = st.split(" ");

        Queue<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(String k : str){
          if(q.contains(k)){
              q.remove(k);

          }else if(q.size()==3){
              sb.append(q.poll()).append("\n");
          }
            q.add(k);
        }
        if(sb.toString().length()==0){
            System.out.print(0);
        }else {
            System.out.print(sb.toString());
        }
    }
}
