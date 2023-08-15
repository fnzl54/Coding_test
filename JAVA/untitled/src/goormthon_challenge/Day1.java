package goormthon_challenge;

import java.util.Scanner;
public class Day1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int W = sc.nextInt();
    int R = sc.nextInt();

    System.out.println((int)(W * (1 + (double)R / 30)));
  }
}
