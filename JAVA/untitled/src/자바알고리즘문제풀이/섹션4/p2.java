package 자바알고리즘문제풀이.섹션4;

import java.util.*;

public class p2 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    HashMap<Character,Integer> Amap = new HashMap<Character,Integer>();
    HashMap<Character,Integer> Bmap = new HashMap<Character,Integer>();

    String a = sc.next();
    String b = sc.next();

    String answer = "YES";

    for (char c : a.toCharArray()) {
      Amap.put(c, Amap.getOrDefault(c, 0) + 1);
    }

    for (char c : b.toCharArray()) {
      Bmap.put(c, Bmap.getOrDefault(c, 0) + 1);
    }


    if (Amap.size() != Bmap.size()) {
      answer = "NO";
    } else {
      for (char c : Amap.keySet()) {
        if (Amap.get(c) != Bmap.getOrDefault(c, 0)) {
          answer = "NO";
        }
      }
    }

    System.out.println(answer);

  }
}