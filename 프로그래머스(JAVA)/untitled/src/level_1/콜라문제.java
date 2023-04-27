package level_1;

import java.util.*;

public class 콜라문제 {
    public static void main(String[] args) {

        int a = 2, b = 1, n = 20;
        int answer = 0;

        //logic
        while (true) {
            if (n < a) {
                break;
            }

            answer += (n / a) * b;
            int remain = n % a;

            n = (n/a) * b + remain;
        }


        //output
        System.out.println(answer);
    }
}
