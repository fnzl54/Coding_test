import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  static int N, X, Y, answer = 0;
  static int[] array, check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    array = new int[25];
    check = new int[N+1]; // 25
    array[X] = array[Y] = Y - X - 1;
    check[Y - X - 1] = 1;

    dfs(1);
    System.out.println(answer);

  }

  private static void dfs(int depth) {
    if (depth == 2*N) {
      answer++;
      return;
    }

    if (array[depth] == 0) {
      for (int i = 1; i <= N; i++) {
        if (check[i] != 1) {
          int temp = depth + i + 1;
          if (temp <= 2 * N && array[temp] == 0) {
            array[depth] = array[temp] = i;
            check[i] = 1;
            dfs(depth + 1);
            array[depth] = array[temp] = check[i] = 0;
          }
        }
      }
    } else {
      dfs(depth + 1);
    }
  }

}