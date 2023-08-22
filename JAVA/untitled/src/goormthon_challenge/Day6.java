package goormthon_challenge;

import java.util.*;

public class Day6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String S = sc.next();
    HashSet<String> set = new HashSet<>();

    for (int i = 1; i < S.length(); i++) {
      for (int j = i + 1; j < S.length(); j++) {
        set.add(S.substring(0, i));
        set.add(S.substring(i, j));
        set.add(S.substring(j));
      }
    }

    List<String> sort_list = new ArrayList<>(set);
    Collections.sort(sort_list);

    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < sort_list.size(); i++) {
      map.put(sort_list.get(i), i+1);
    }

    int max = 0;
    for (int i = 1; i < S.length(); i++) {
      for (int j = i + 1; j < S.length(); j++) {
        int temp_add = 0;
        temp_add += map.get(S.substring(0, i));
        temp_add += map.get(S.substring(i, j));
        temp_add += map.get(S.substring(j));

        if (temp_add > max) {
          max = temp_add;
        }
      }
    }

    System.out.println(max);
  }
}