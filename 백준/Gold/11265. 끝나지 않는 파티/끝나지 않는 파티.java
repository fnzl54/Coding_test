import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int k = 0; k < N; k++) { // K는 거쳐가는 파티장
      for(int i = 0; i < N; i++) {
        if(i == k) {
          continue;
        }

        for(int j = 0; j < N; j++) {
          if( i==j || j==k ) {
            continue;
          }

          if(map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }

    for(int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken())-1;
      int end = Integer.parseInt(st.nextToken())-1;
      int time = Integer.parseInt(st.nextToken());

      if(time >= map[start][end]) {
        sb.append("Enjoy other party").append("\n");
      } else {
        sb.append("Stay here").append("\n");
      }
    }

    System.out.print(sb);
  }
}
