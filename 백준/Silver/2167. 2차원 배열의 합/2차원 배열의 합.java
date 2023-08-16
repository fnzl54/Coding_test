import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] li = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        li[i][j] = sc.nextInt();
      }
    }

    int K = sc.nextInt();
    int[][] q_li = new int[K][4];
    for (int i = 0; i < K; i++) {
      for (int j = 0; j < 4; j++) {
        q_li[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < K; i++) {
      int answer = 0;

      for (int j = 0; j < q_li[i][2] - q_li[i][0] + 1; j++) { // 0 1
        for (int k = 0; k < q_li[i][3] - q_li[i][1] + 1; k++) { // 0 1 2
          answer += li[q_li[i][0] - 1 + j][q_li[i][1] - 1 + k];
        }
      }

      System.out.println(answer);
    }
  }
}