import java.util.Stack;

public class ReverseWord {

    public static void main(String[] args) {
        Stack<String> stack =  new Stack<>();

        String str = "abcdefghijklmnop";

        StringBuilder stringBuilder = new StringBuilder();

        char k [] = str.toCharArray();
        for(char ch : k){
            if(stack.size()==5){
                while(!stack.isEmpty()){
                    stringBuilder.append(stack.pop());
                }
                stack.add(String.valueOf(ch));
            }else{
                stack.add(String.valueOf(ch));
            }
        }
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        System.out.print(stringBuilder.toString());
    }
}
