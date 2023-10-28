import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int R =  Integer.parseInt(st.nextToken());
    int C =  Integer.parseInt(st.nextToken());
    int Q =  Integer.parseInt(st.nextToken());
    int sum, r1, c1,r2,c2;
    int[][] picture = new int[R+1][C+1];


    for (int i = 1; i <= R; i++) {
      st = new StringTokenizer(br.readLine());
      sum = 0;
      for (int j = 1; j <= C; j++) {
        sum += Integer.parseInt(st.nextToken());
        picture[i][j] = sum + picture[i - 1][j];
      }
    }

    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      r1 = Integer.parseInt(st.nextToken());
      c1 = Integer.parseInt(st.nextToken());
      r2 = Integer.parseInt(st.nextToken());
      c2 = Integer.parseInt(st.nextToken());

      sb.append((picture[r2][c2] - picture[r1 - 1][c2] - picture[r2][c1 - 1] + picture[r1 - 1][c1 - 1]) / ((r2 - r1 + 1) * (c2 - c1 + 1))).append("\n");
    }

    System.out.println(sb);

  }
}