package level_2;

import java.util.*;

public class 숫자의표현 {
    public static void main(String[] args) {

        int n = 15;
        int answer = 0;

        //logic
        int add_num = 0;

        for (int i = 1; i <= n; i++) {

            add_num = 0;

            for (int j = i; j <= n; j++) {
                add_num += j;

                if (add_num == n) {
                    answer++;
                    break;
                } else if (add_num > n) {
                    break;
                }

            }
        }


        //output
        System.out.println(answer);
    }
}
