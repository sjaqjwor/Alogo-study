import java.util.HashSet;
import java.util.Set;
    import java.util.Stack;

public class SummerCoding2018English {

    public static void main(String[] args) {
        solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});

     solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});

    }
    static int[] solution(int n ,String[] words){
        Stack<String> st = new  Stack<>();

        int count=1;
        st.add(words[0]);

        for(int a=1;a<words.length;a++){
            String k = st.peek();
            if(k.charAt(k.length()-1) != words[a].charAt(0)){
                count=a+1;
                break;
            }
            if(st.contains(words[a])){
                count=a+1;
                break;
            }
            st.add(words[a]);

        }


        int answer[]  = new int[2];

        if(count==1){
            answer[0]=0;
            answer[1]=0;
        } else if(count%n==0){
            answer[0]=n;
            answer[1]=count/n;
        }else{
            answer[0]=count%n;
            answer[1]=count/n;
        }


        System.out.println(answer[0]);

        System.out.println(answer[1]);
        return answer;
    }

}
