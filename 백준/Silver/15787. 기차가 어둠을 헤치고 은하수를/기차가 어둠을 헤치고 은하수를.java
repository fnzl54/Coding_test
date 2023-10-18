import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Set<String> trainFinal = new HashSet<>();

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] train = new int[N+1][20];

    for (int k = 0; k < K; k++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken()), i = 0, x = 0;
      switch (num) {
        case 1:
          i = Integer.parseInt(st.nextToken());
          x = Integer.parseInt(st.nextToken())-1;
          train[i][x] = 1;
          break;
        case 2:
          i = Integer.parseInt(st.nextToken());
          x = Integer.parseInt(st.nextToken())-1;
          train[i][x] = 0;
          break;
        case 3:
          i = Integer.parseInt(st.nextToken());
          for (int n = 19; n > 0; n--) {
            train[i][n] = train[i][n-1];
          }
          train[i][0] = 0;
          break;
        case 4:
          i = Integer.parseInt(st.nextToken());
          for (int n = 0; n < 19; n++) {
            train[i][n] = train[i][n+1];
          }
          train[i][19] = 0;
          break;
      }
    }

    for (int n = 1; n < N+1; n++) {
      String s = Arrays.toString(train[n]);
      trainFinal.add(s);
    }

    System.out.println(trainFinal.size());
  }
}