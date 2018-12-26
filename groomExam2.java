import java.io.BufferedReader;
import java.io.InputStreamReader;

public class groomExam2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(new StringBuilder(input).reverse());
    }
}
