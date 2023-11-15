import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] sum = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
    }

    map.put(0,1);

    long answer = 0;
    for (int i = 1; i <= N; i++) {
      answer += map.getOrDefault(sum[i] - K, 0);
      map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
    }

    System.out.println(answer);
  }
}