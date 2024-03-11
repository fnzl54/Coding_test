import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String input1 = br.readLine();
    String input2 = br.readLine();

    int[] nowA = new int[N];
    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
      nowA[i] = input1.charAt(i)-'0';
    }
    for (int i = 0; i < N; i++) {
      result[i] = input2.charAt(i)-'0';
    }

    int[] nowB = Arrays.copyOf(nowA, N);
    nowB[0] = 1-nowB[0];
    nowB[1] = 1-nowB[1];

    int answer = solve(N, nowA, result);
    int answer2 = solve(N, nowB, result);
    if (answer2 != -1) {
      answer2++;
    }

    if (answer == -1)
      System.out.println(answer2);
    else if (answer2 == -1)
      System.out.println(answer);
    else {
      System.out.println(Math.min(answer2, answer));
    }

  }

  private static int solve(int N, int[] now, int[] result) {
    int cnt = 0;

    for (int i = 0; i < N-1; i++) {
      if (now[i]!=result[i]) {
        cnt++;
        now[i] = 1-now[i];
        now[i+1] = 1-now[i+1];

        if (i != N-2) { // 마지막 처리
          now[i+2] = 1-now[i+2];
        }
      }
    }

    return now[N-1] != result[N-1] ? -1 : cnt;
  }

}