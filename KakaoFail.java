import java.util.*;
// 보고 풀었다..

//어렵다
public class KakaoFail {
    static Comparator<Integer> comp = new Comparator<Integer>() {
        int compareBit(int n){
            int ret = 0;

            while(n!=0){
                if((n & 1)!=0) ret++;
                n=n>>1;
            }
            return ret;
        }
        @Override
        public int compare(Integer o1, Integer o2) {
            int x = compareBit(o1);
            int y  = compareBit(o2);
            if(x>y){
                return 1;
            }else if(y>x){
                return -1;
            }else{
                return 0;
            }
        }
    };
    public static void main(String[] args) {
        String arr[][] = new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"}
        ,{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solution(arr));
    }
    static int solution(String[][] relation) {
        int answer = 0;
       int rowsize = relation.length;
       int colsize = relation[0].length;

        List<Integer> candidates = new LinkedList<Integer>();

        // 컬럼으로 만들수 있는 경우의수
        for(int i=1;i< 1 << colsize;i++){
            if(check(relation,rowsize,colsize,i)==true){
                candidates.add(i);
            }
        }
        Collections.sort(candidates,comp);
        while(!candidates.isEmpty()){
            int n = ((LinkedList<Integer>) candidates).remove();
            answer++;
            Iterator<Integer> iterator = candidates.iterator();
            while(iterator.hasNext()){
                int c = iterator.next();
                if((n & c)==n) iterator.remove();
            }
        }
        return answer;
    }
    // 유일성 판단
    static boolean check(String relation[][],int rowsize,int colosize,int subset){
        for(int a=0;a<rowsize-1;a++){
            for(int b=a+1;b<rowsize;b++){
                boolean isTrue=true;
                for(int k=0; k<colosize;k++){
                    int num = 1<<k;
                    if((subset & num)==0)continue;
                    String before=relation[a][k];
                    String after =relation[b][k];
                    if(!before.equals(after)){
                        isTrue=false;
                        break;
                    }
                }
                if(isTrue) return false;
            }
        }
        return true;
    }
}
