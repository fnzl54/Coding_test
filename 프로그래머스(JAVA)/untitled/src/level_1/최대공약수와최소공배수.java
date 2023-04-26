package level_1;

import java.util.*;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) {

        int n = 3, m = 12;
        int[] answer = new int[2];

        //logic

        int a = Math.max(n, m), b =  Math.min(n, m);

        while (b != 0) {
            int res = a % b;
            a = b;
            b = res;
        }

        answer[0] = a;
        answer[1] = (n * m) / a;

        //output
        System.out.println(answer);
    }
}