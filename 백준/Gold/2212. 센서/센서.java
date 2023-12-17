import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());
    int answer = 0;

    int[] sensor = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      sensor[n] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(sensor);

    int[] differenceDistance = new int[N-1];
    for (int n = 0; n < N-1; n++) {
      differenceDistance[n] = sensor[n+1] - sensor[n];
    }
    Arrays.sort(differenceDistance);

    for (int i = 0; i < (N - 1) - (K - 1); i++) {
      answer += differenceDistance[i];
    }

    System.out.println(answer);
  }
}
