package goormthon_challenge;

import java.util.*;

public class Day5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    HashMap<Integer, ArrayList<Integer>> one_count_map = new HashMap<>();
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      int temp_num_10 = sc.nextInt();
      String temp_num_2 =  Integer.toString(temp_num_10, 2);

      int count = 0;
      for (int j = 0; j < temp_num_2.length(); j++) {
        if (temp_num_2.charAt(j) == '1') {
          count++;
        }
      }

      // map에 넣는 과정
      if (one_count_map.containsKey(count)) {
        one_count_map.get(count).add(temp_num_10);
      } else {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(temp_num_10);
        one_count_map.put(count, temp);
      }
    }

    for (int i : one_count_map.keySet()) {
      List<Integer> temp = new ArrayList<>(one_count_map.get(i));
      Collections.sort(temp);

      for (int j : temp) {
        answer.add(j);
      }

    }

    System.out.println(answer.get(N - K));

  }
}