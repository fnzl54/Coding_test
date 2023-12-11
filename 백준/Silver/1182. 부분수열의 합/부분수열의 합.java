import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, S, answer = 0, D;
  static int[] input;
  static List<Integer> arr = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    input = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      input[n]= Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      D = i;
      dfs(0, 0);
    }

    System.out.println(answer);

  }

  static void dfs (int depth, int start) {
    if (depth == D) {
      int sum = arr.stream().mapToInt(Integer::intValue).sum();
      if (sum == S) {
        answer++;
      }
      return;
    }

    for (int i = start; i < N; i++) {
      arr.add(input[i]);
      dfs(depth + 1, i + 1);
      arr.remove(arr.size() - 1);

    }
  }

}