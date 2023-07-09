package 자바알고리즘문제풀이.섹션4;

import java.util.*;

public class p1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int max = 0;
    char answer = ' ';
    String s = sc.next();
    HashMap<Character, Integer> map = new HashMap<>();


    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    for (char k : map.keySet()) {
      if (map.get(k) > max) {
        max = map.get(k);
        answer = k;
      }
    }

    System.out.println(answer);

  }

}
