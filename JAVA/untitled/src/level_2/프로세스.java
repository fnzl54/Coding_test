package level_2;

import java.util.*;

public class 프로세스 {
    public static void main(String[] args) {

        int[] priorities = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int location = 1;
        int answer = 0;

        //logic
        Queue<Integer> q = new LinkedList<>();

        for (int i : priorities) {
            q.add(i);
        }


        int max = Collections.max(q);
        int q_size = q.size();
        int location_num = 0;
        int rank_num = 1;

        while (!q.isEmpty()) {
            int now_num = q.poll();

            if (now_num != max) {
                q.add(now_num);
            } else {
                if (location_num % q.size() == location) {
                    answer = rank_num;
                    break;
                }
                if (!q.isEmpty())  max = Collections.max(q);
                rank_num++;
            }

            location_num++;
        }

        //output
        System.out.println(answer);
    }
}