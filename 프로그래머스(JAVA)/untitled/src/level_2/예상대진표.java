package level_2;

import java.util.*;

public class 예상대진표 {
    public static void main(String[] args) {

        int n = 8, a = 4, b = 7;
        int answer = 1;

        //logic
        while (Math.abs(b - a) != 1 || Math.max(a, b) % 2 != 0) {
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            answer++;
        }


        //output
        System.out.println(answer);
    }
}