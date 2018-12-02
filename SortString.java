import java.util.*;

public class SortString {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,1,2,2,4);
        customSort(list);
    }
    static void customSort(List<Integer> arr){
        Map<Integer, Integer> map  = new HashMap<>();

        for(int k : arr){
            map.merge(k,1,Integer::sum);
        }
        List<Word> list = new ArrayList<>();

        for(Map.Entry m : map.entrySet()){
            list.add(new Word((Integer) m.getKey(),(Integer) m.getValue()));
        }

        Collections.sort(list);

        for(Word w : list){
            for(int a=0;a<w.count;a++){
                System.out.println(w.num);
            }
        }
    }
}
class Word implements Comparable<Word>{
    int num;
    int count;

    public Word(int num , int count){

        this.num=num;
        this.count=count;
    }

    @Override
    public int compareTo(Word o) {
        if(this.count>o.count){
            return 1;
        }else if(this.count<o.count){
            return -1;
        }else {
            return 0;
        }
    }
}
