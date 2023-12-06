import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M;
  static int[] arr, check;
  static List<Integer> input = new ArrayList<>();
  static Set<String> answer = new HashSet<>();
  static List<String> answer_list = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      input.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(input);
    arr = new int[M];
    check = new int[N];

    dfs(0);


    for (String s : answer_list) {
      sb.append(s).append("\n");
    }

    System.out.println(sb);
  }

  static void dfs (int depth) {
    if (depth == M) {
      StringBuilder temp_sb = new StringBuilder();
      for (int i : arr) {
        temp_sb.append(i).append(" ");
      }
      if (!answer.contains(temp_sb.toString())) {
        answer.add(temp_sb.toString());
        answer_list.add(temp_sb.toString());
      }

      return;
    }

    for (int n = 0; n < input.size(); n++) {
      if (check[n] == 0) {
        arr[depth] = input.get(n);
        check[n] = 1;
        dfs(depth + 1);
        check[n] = 0;
      }
    }
  }

}