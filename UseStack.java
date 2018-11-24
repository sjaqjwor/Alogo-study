import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class UseStack {

    public static void main(String[] args) {
        List<Stack<Integer>> stackList = doDo();
        for (Stack<Integer> stack : stackList) {
            for (Integer element : stack) {
                System.out.print(element.toString()  + " ");
            }
            System.out.println();
        }
    }
    static List<Stack<Integer>> doDo() {
        final List<Integer> elements = Arrays.asList(9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2);

        List<Stack<Integer>> stacks = new ArrayList<>();

        int num=0;
        Stack<Integer> stack = new Stack<>();
        for(int k : elements){
            if(num+k <= 20){
                num+=k;
                stack.add(k);
            }else{
                stacks.add(stack);
                stack= new Stack<>();
                num=0;
                num+=k;
                stack.add(k);
            }
        }
        stacks.add(stack);
        return stacks;
    }
}
