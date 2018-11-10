import java.util.HashMap;
import java.util.Map;

public class SUmmerCoding2018Block {

    public static void main(String[] args) {
        System.out.print(solution(new int[][]{{4,4, 3}, {3,2, 2},{2,1,0}},5,3));
    }
    static long solution(int[][] land, int P, int Q) {
        long answer = 0;
        long max = Long.MAX_VALUE;

        Map<Integer , Long> map = new HashMap<>();
        for (int a = 0; a < land.length; a++) {
            for (int b = 0; b < land.length; b++) {
                map.merge(land[a][b],new Long(1),Long::sum);
            }
        }
        int maxcount=0;
        long maxnum=0;
        for(Map.Entry m : map.entrySet()){
            if(maxnum<(Long)m.getValue()){
                maxcount=(int)m.getKey();
                maxnum=(Long)m.getValue();
            }
        }
        System.out.println(maxcount);
            for (int a = 0; a < land.length; a++) {
                for (int b = 0; b < land.length; b++) {
                    if (land[a][b] > maxcount) {
                        answer += (land[a][b] - maxcount) * Q;
                    }
                    if (land[a][b] < maxcount) {
                        answer += (maxcount - land[a][b]) * P;
                    }
                }
        }
        return answer;
    }
}
