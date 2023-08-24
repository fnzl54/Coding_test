package goormthon_challenge;

import java.io.FilterOutputStream;
import java.util.*;

public class Day8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int answer = 0;

    answer += N / 14;
    N -= (N / 14) * 14;

    answer += N / 7;
    N -= (N / 7) * 7;

    answer += N;

    System.out.println(answer);
  }

}