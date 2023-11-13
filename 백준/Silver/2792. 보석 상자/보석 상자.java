import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] jewel = new int[M];
    int left = 1, right = 0, answer = 0;

    for (int m = 0; m < M; m++) {
      jewel[m] = Integer.parseInt(br.readLine());
      right = Math.max(right, jewel[m]);
    }

    while (left <= right) {
      int mid = (left + right) / 2;
      int sum = 0;
      for (int i = 0; i < M; i++) {
        sum += jewel[i] / mid;
        if (jewel[i] % mid != 0) {
          sum++;
        }
      }

      if (sum > N) {
        left = mid + 1;
      } else {
        right = mid - 1;
        answer = mid;
      }
    }

    System.out.println(answer);
  }
}
