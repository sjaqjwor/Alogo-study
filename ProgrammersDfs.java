import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersDfs {
    public static void main(String[] args) {
        solution("hit","cog",new String[]{ "hot","dot","dog", "lot", "log"});

    }
    static int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        boolean check []  = new boolean[words.length];
        Queue<ProgrammersName> queue = new LinkedList<>();
        queue.add(new ProgrammersName(begin,0));
        while(!queue.isEmpty() ){

            String name = queue.peek().name;
            int num = queue.peek().count;
            queue.poll();
            if(name.equals(target)){
                answer=num;
                break;
            }
            if(num>words.length+1){
                break;
            }
            for(int a=0;a<words.length;a++){
                if(checkAlpa(words[a],name) && !check[a]){
                    queue.add(new ProgrammersName(words[a],num+1));
                }
            }

        }

        System.out.println(answer);
        return answer;
    }
    static boolean checkAlpa(String str , String str1){

        int count=0;
        for(int a=0;a<str.length();a++){
            if(str.charAt(a)!=str1.charAt(a)){
                count++;
                if(count>1){
                    return false;
                }
            }
        }

        return true;
    }
}
class ProgrammersName{
    String name;
    int count;

    public ProgrammersName(String name, int count){
        this.name=name;
        this.count=count;
    }
}
