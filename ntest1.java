import java.util.*;

public class ntest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = sc.nextInt();
        int arr[] = new int[count];

        for(int a=0;a<count;a++){
            arr[a]=sc.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();

        for(int a=1;a<=N;a++){
            deque.add(a);
        }
        for(int a=0;a<count;a++){
            while(deque.size()>(2*count)){
                for(int b=0;b<arr[a];b++){
                    stack.add(deque.pollLast());
                }
                for(int b=0;b<arr[a];b++){
                    stack1.add(deque.pollFirst());
                }
                while(!stack1.isEmpty()){
                    stack.add(stack1.pop());
                }
            }
            while (!deque.isEmpty()){
                stack.add(deque.pollLast());
            }
            while (!stack.isEmpty()){
                deque.add(stack.pop());
            }
        }
        for(int a=0;a<5;a++){
            System.out.println(deque.pollFirst());
        }

    }

}
