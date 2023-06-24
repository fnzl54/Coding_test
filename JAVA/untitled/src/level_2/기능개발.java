package level_2;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        //logic

        for (int i = 0; i < progresses.length; i++) {
            if ( (100 - progresses[i]) % speeds[i]  == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else {
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int count = 1;
        int now = q.poll();

        while (!q.isEmpty()) {
            if (now >= q.peek()) {
                count++;
                q.poll();
            } else {
                answer.add(count);
                count = 1;
                now = q.poll();
            }
        }

        answer.add(count);

        //output
        System.out.println(answer);
    }
}
