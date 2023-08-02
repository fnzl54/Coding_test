package 자바알고리즘문제풀이.섹션6;

import java.util.*;

public class p4 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int S = sc.nextInt();
    List<Integer> cache = new ArrayList<>();
    int N = sc.nextInt();
    int[] use_num = new int[N];

    for (int i = 0; i < N; i++) {
      use_num[i] = sc.nextInt();
    }

    cache.add(use_num[0]);

    for (int i = 1; i < use_num.length; i++) {

      if (cache.contains(use_num[i])) {
        cache.remove(Integer.valueOf(use_num[i]));
        cache.add(use_num[i]);
      } else {
        if (cache.size() == S) {
          cache.remove(0);
          cache.add(use_num[i]);
        } else {
          cache.add(use_num[i]);
        }
      }
    }

    for (int i = cache.size()-1; i >= 0; i--) {
      System.out.print(cache.get(i) + " ");
    }

  }
}
