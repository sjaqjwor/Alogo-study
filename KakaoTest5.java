import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KakaoTest5 {
    public static void main(String[] args) {
        int answer[][] = solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
        for(int a=0;a<2;a++){
            for(int b=0;b<9;b++){
                System.out.print(answer[a][b]+" ");
            }
            System.out.println();
        }
    }
    static int[][] solution(int[][] nodeinfo) {
        List<Node> list = new ArrayList<Node>();
        int num=1;

        for(int node[] : nodeinfo){
            Node node1 = new Node(node[0],node[1],num);
            list.add(node1);
            num++;
        }
        Collections.sort(list);
        int answer[][] =new int[2][list.size()];
        createTree(list,answer);
        return answer;
    }
    static void createTree(List<Node> list,int answer[][]){
        Node head = list.get(0);
        list.remove(0);

        for(Node n : list){
            insertNode(head,n);
        }
        StringBuilder st = new StringBuilder();
        pre(head,st);
        String str[] = st.toString().split(" ");
        for(int a=0;a<str.length;a++){
            answer[0][a]=Integer.parseInt(str[a]);
        }
        st = new StringBuilder();
        post(head,st);
        str = st.toString().split(" ");
        for(int a=0;a<str.length;a++){
            answer[1][a]=Integer.parseInt(str[a]);
        }
    }
    static void insertNode(Node head,Node next){
        if(head.x > next.x){
            if(head.left==null){
                head.left=next;
            }else{
                head=head.left;
                insertNode(head,next);
            }
        }else{
            if(head.right==null){
                head.right=next;
            }else{
                head=head.right;
                insertNode(head,next);
            }
        }
    }
    static void pre(Node head,StringBuilder st){
        if(head!=null){
            st.append(head.number).append(" ");
            pre(head.left,st);
            pre(head.right,st);
        }
    }
    static void post(Node head,StringBuilder st){
        if(head!=null){
            post(head.left,st);
            post(head.right,st);
            st.append(head.number).append(" ");
        }
    }

}
class Node implements Comparable<Node> {
    int number;
    int x;
    int y;
    Node left;
    Node right;

    Node(int x, int y,int num){
        this.number=num;
        this.x=x;
        this.y=y;
        this.left=left;
        this.right=right;
    }



    @Override
    public int compareTo(Node o) {
        if(this.y>o.y){
            return -1;
        }else if(this.y<o.y){
            return 1;
        }else{
            return 0;
        }
    }
}
