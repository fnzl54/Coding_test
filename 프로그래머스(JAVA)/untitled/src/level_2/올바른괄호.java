package level_2;

import java.util.*;

public class 올바른괄호 {
    public static void main(String[] args) {

        String s = ")()(";
        boolean answer = true;

        //logic
        Queue<Character> q = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if ( c == '(') {
                q.add(c);
            } else {
                if (q.isEmpty()) {
                    answer = false;
                } else {
                    q.poll();
                }
            }
        }

        if (!q.isEmpty()) {
            answer = false;
        }


        //output
        System.out.println(answer);
    }
}