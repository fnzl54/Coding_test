import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static int N, L, R, X, answer = 0;
  public static int[] problem;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 문제 갯수
    L = Integer.parseInt(st.nextToken()); // 난이도 합 L 크가거 같음
    R = Integer.parseInt(st.nextToken()); // 난이도 합 R 작거나 같음
    X = Integer.parseInt(st.nextToken()); // 가장 어려운 문제와 쉬운 문제의 난이도 차이 X 보다 크거나 같음

    problem = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      problem[n] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(problem);
    dfs(0, Integer.MIN_VALUE, Integer.MAX_VALUE,0);

    System.out.println(answer);
  }

  private static void dfs(int depth, int max, int min, int sum) {

    if (depth == N) {
      if (sum >= L && sum <= R && max - min >= X) {
        answer ++;
      }
      return;
    }

    dfs(depth+1, Math.max(max, problem[depth]), Math.min(min, problem[depth]), sum+problem[depth]); // 문제를 넣는 경우
    dfs(depth+1, max, min, sum); // 문제를 넣지 않는 경우
  }
  
}
