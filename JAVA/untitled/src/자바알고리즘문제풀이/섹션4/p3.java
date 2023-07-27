package 자바알고리즘문제풀이.섹션4;

import java.util.*;

public class p3 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] li = new int[N];
    int left = 0, right = K;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> answer = new ArrayList<Integer>();

    for (int i = 0; i < N ; i++) {
      li[i] = sc.nextInt();
    }

    for (int i = 0; i < K; i++) {
      map.put(li[i], map.getOrDefault(li[i], 0) + 1);
    }


    while (right != N) {
      int temp = 0;
      answer.add(map.size());

      if (map.get(li[left]) - 1 == 0) {
        map.remove(li[left]);
      } else {
        map.put(li[left], map.get(li[left]) - 1);
      }
      map.put(li[right], map.getOrDefault(li[right], 0) + 1);
      left++;
      right++;
    }

    int temp = 0;
    for (int c : map.keySet()) {
      if (map.get(c) != 0) {
        temp++;
      }
    }
    answer.add(temp);

    for (int i : answer) {
      System.out.print(i + " ");
    }

  }
}
