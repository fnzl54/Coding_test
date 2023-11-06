import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] solution = new int[N];
    int left = 0, right = N-1;
    int gap = Integer.MAX_VALUE;
    int answer1 = 0, answer2 = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      solution[n] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(solution);

    while (left < right) {
      int sum = solution[left] + solution[right];
      int absSum = Math.abs(sum);
      if (absSum < gap) {
        gap = absSum;
        answer1 = solution[left];
        answer2 = solution[right];
      }
      if (sum > 0) {
        right--;
      } else {
        left++;
      }
    }

    System.out.println(answer1 + " " + answer2);
  }
}