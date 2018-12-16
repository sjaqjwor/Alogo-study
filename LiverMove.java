import javafx.scene.layout.Priority;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LiverMove {
    public static void main(String[] args) throws Exception {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        boolean check = false;
        for (int a = 0; a < num; a++) {
            String st = br.readLine();

            if (priorityQueue.isEmpty()) {
                String str[] = st.split(" ");
                for (String temp : str) {
                    priorityQueue.add(Integer.parseInt(temp));
                }
            } else {

                String str[] = st.split(" ");
                for (String temp : str) {
                    if (priorityQueue.contains(Integer.parseInt(temp))) {
                        check = true;
                    }
                }
                if (!check) {
                    System.out.println(priorityQueue.peek());
                    priorityQueue.clear();
                    for (String temp : str) {
                        priorityQueue.add(Integer.parseInt(temp));
                    }
                } else {
                    check = false;
                    for (int b = 0; b < str.length; b++) {
                        if (priorityQueue.contains(Integer.parseInt(str[b]))
                        ) {
                            while (b < str.length && Integer.parseInt(str[b]) <= priorityQueue.peek()) {
                                b++;
                                if (!priorityQueue.contains(Integer.parseInt(str[b]))) {
                                    check = true;
                                    break;
                                }
                            }
                        }
                        if (check) {
                            break;
                        } else {
                            priorityQueue.add(Integer.parseInt(str[b]));
                        }
                    }

                }
            }

            if (check) {
                System.out.println(-1);
            }
        }
        if (check) {
            System.out.println(-1);
        } else {
            System.out.println(priorityQueue.peek());
        }
    }
}
