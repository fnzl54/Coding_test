package 자바알고리즘문제풀이.섹션3;

import java.util.*;

import java.util.*;

public class p4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int answer = 0;

        int[] li = new int[n];

        for (int i = 0; i < n; i++) {
            li[i] = sc.nextInt();
        }

        int f = 0, e = 1;

        while (e < n) {
            int temp = 0;

            for (int i = f; i <= e; i++) {
                temp += li[i];
            }

            if (temp == a) {
                answer++;
                e++;
            } else if (temp < a) {
                e++;
            } else {
                f++;
            }
        }

        System.out.println(answer);

    }
}