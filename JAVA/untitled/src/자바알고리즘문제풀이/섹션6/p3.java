package 자바알고리즘문제풀이.섹션6;

import java.util.*;

public class p3 {
    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int[] li = new int[N];

      for (int i = 0; i < N; i++) {
        li[i] = sc.nextInt();
      }

      for (int i = 1; i < N; i++) {
        int temp = li[i];

        for (int j = i; j >= 0; j--) {
          if (j-1 < 0) {
            li[j] = temp;
          }
          else if (temp < li[j-1]) {
            li[j] = li[j-1];
          } else {
            li[j] = temp;
            break;
          }
        }
      }

      for (int i : li) {
        System.out.print(i + " ");
      }

    }
}