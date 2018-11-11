import java.util.Stack;

public class TestString {


    public static void main(String[] args) {

        System.out.print(soloution("ACCAABBC"));
        System.out.println();
        System.out.print(soloution("ABCBBCBA"));


    }
    static String soloution(String str){

        StringBuilder st = new StringBuilder();

        Stack<String> stack = new Stack<>();

        stack.add(String.valueOf(str.charAt(0)));
        for(int a=1;a<str.length();a++){
            if(!stack.isEmpty() && stack.peek().equals(String.valueOf(str.charAt(a)))){
                stack.pop();
            }else{
                stack.push(String.valueOf(str.charAt(a)));
            }
        }
        while (!stack.isEmpty()){
            st.insert(0,stack.pop());
        }
        return st.toString();
    }
}
