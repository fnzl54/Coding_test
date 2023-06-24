package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class p1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next().toLowerCase();
    char c = sc.next().toLowerCase().charAt(0);

    System.out.println(solution(s, c));
  }

  public static int solution(String s, char c) {
    int answer = 0;

    for (char sList : s.toCharArray()) {
      if (sList == c) answer++;
    }

    return answer;
  }

}