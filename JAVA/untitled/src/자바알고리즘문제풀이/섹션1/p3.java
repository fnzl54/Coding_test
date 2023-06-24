package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class p3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String test = sc.nextLine();
    String[] testList = test.split(" ");

    String answer = "";

    for (String s : testList) {
      if (answer.length() < s.length()) {
        answer = s;
      }
    }

    System.out.println(answer);
  }

}