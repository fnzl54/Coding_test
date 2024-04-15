import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

  static int N;
  static int[] input;
  static ArrayList<Integer> list;
  static boolean[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    input = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    list = new ArrayList<>();
    check = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      check[i] = true;
      dfs(i, i);
      check[i] = false;
    }

    Collections.sort(list);

    sb.append(list.size()).append("\n");
    for (int i : list) {
      sb.append(i).append("\n");
    }

    System.out.println(sb);

  }

  public static void dfs(int start, int target) {
    if (check[input[start]] == false) {
      check[input[start]] = true;
      dfs(input[start], target);
      check[input[start]] = false;
    }

    if (input[start] == target) {
      list.add(target);
    }
  }

}
