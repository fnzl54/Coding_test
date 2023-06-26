package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class q6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    Set<Character> set = new HashSet<>();
    List<Character> answerList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();


    for (char c : s.toCharArray()) {
      if (!set.contains(c)) {
        set.add(c);
        answerList.add(c);
      }
    }

    for (char c : answerList) {
      sb.append(c);
    }

    System.out.println(sb);

  }

}
