import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackMsg {

    public static void main(String[] args) {
        String str = "SMS messages are really short";

        String info[] = str.split(" ");

        Stack<String> stack = new Stack<>();
        int sum=0;
        for(String k : info){
            if(k.length()>12){
                System.out.println(-1);
                break;
            }else if(stack.size()+k.length() >12) {
                sum++;
                stack.clear();
                for(int a=0;a<k.length();a++){
                    stack.add(String.valueOf(k.charAt(a)));
                }
            }else{
                for(int a=0;a<k.length();a++){
                    stack.add(String.valueOf(k.charAt(a)));
                }
            }
        }
        if(stack.size()<=12){
            sum++;
        }
        System.out.println(sum);
    }
}
