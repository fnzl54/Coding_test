package goormthon_challenge;

import java.util.*;

public class Day3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int answer = 0;

    for (int i = 0; i < T; i++) {
      int a = sc.nextInt();
      String s = sc.next();
      int b = sc.nextInt();

      switch (s) {
        case "+":
          answer += (a + b);
          break;
        case "-":
          answer += (a - b);
          break;
        case "/":
          answer += (a / b);
          break;
        case "*":
          answer += (a * b);
          break;
        default :
          break;
      }
    }

    System.out.println(answer);
  }
}