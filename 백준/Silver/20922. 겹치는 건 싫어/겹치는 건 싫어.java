import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] count = new int[100001];

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] input = new int[N];
    int left = 0, right = 1, answer = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    count[input[left]]++;
    while (left <= right) {
      if (count[input[right]] < K) {
        count[input[right]]++;
        right++;
      } else if (count[input[right]] == K) {
        count[input[left]]--;
        left++;
      }

      answer = Math.max(answer, right - left);
      if(right == N) {
        break;
      }
    }

    System.out.println(answer);
  }
}
