package 자바알고리즘문제풀이.섹션4;

import java.util.*;

public class p4 {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();
    int answer = 0;

    HashMap smap = new HashMap<String, Integer>();
    HashMap tmap = new HashMap<String, Integer>();

    for (char c : T.toCharArray()) {
      tmap.put(c, (int)tmap.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < T.length(); i++) {
      smap.put(S.charAt(i), (int)smap.getOrDefault(S.charAt(i), 0) + 1);
    }

    int left = 0, right = T.length();

    while (right != S.length()) {
      if ( smap.equals(tmap) ) {
        answer++;
      }

      smap.put(S.charAt(right), (int)smap.getOrDefault(S.charAt(right), 0) + 1);

      if ((int)smap.get(S.charAt(left)) == 1) {
        smap.remove(S.charAt(left));
      } else {
        smap.put(S.charAt(left), (int)smap.get(S.charAt(left)) - 1);
      }

      left++;
      right++;
    }

    if ( smap.equals(tmap) ) {
      answer++;
    }


    System.out.print(answer);

  }
}