import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int H, W, answer = 0;
    static int[] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    map = new int[W];
    st = new StringTokenizer(br.readLine());
    for (int w = 0; w < W; w++) {
      map[w] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < W - 1; i++) {
      int left = 0;
      int right = 0;

      for(int j = 0; j < i; j++) {
        left = Math.max(map[j], left);
      }
      for(int j = i + 1; j < W; j++) {
        right = Math.max(map[j], right);
      }

      if (map[i] < left && map[i] < right) {
        answer += Math.min(left, right) - map[i];
      }
    }

    System.out.println(answer);

  }

}