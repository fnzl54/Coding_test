package goormthon_challenge;

import java.util.*;

public class Day4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] food = new int[N];
    int max = 0;
    int max_position = 0;
    int check_num = 0;

    for (int i = 0; i < N; i++) {
      food[i] = sc.nextInt();

      if (max < food[i]) {
        max = food[i];
        max_position = i;
      }
    }

    int temp_max = max;
    for (int i = max_position-1; i >= 0; i--) {
      if (temp_max >= food[i]) {
        temp_max = food[i];
      } else {
        check_num = 1;
        break;
      }
    }

    if (check_num == 0) {
      temp_max = max;
      for (int i = max_position; i < N; i++) {
        if (temp_max >= food[i]) {
          temp_max = food[i];
        } else {
          check_num = 1;
          break;
        }
      }
    }

    if (check_num == 0) {
      int answer = 0;
      for (int i = 0; i < N; i++) {
        answer += food[i];
      }
      System.out.println(answer);
    } else {
      System.out.println(0);
    }

  }
}