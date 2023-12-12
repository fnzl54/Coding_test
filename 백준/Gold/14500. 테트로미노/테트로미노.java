// 오류 : https://www.acmicpc.net/board/view/57920
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static int N, M, answer = Integer.MIN_VALUE;
  static int[][] input, check, pinkShape = {{0,1,2}, {0,1,3}, {0,2,3}, {1,2,3}}; // ㅗ ㅓ ㅏ ㅜ
  static int[] arr = new int[4];
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    input = new int[N][M];
    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        input[n][m] = Integer.parseInt(st.nextToken());
      }
    }
    check = new int[N][M]; // dfs 에서만 사용

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        check[n][m] = 1;
        dfs(0, new int[] {n, m}); // 4개로 이어진 테트로미노에서 최댓값을 찾음
        check[n][m] = 0;
        pinkShapeCheck(new int[] {n, m}); // ㅗ ㅓ ㅏ ㅜ 모형의 최댓값을 찾음
      }
    }

    System.out.println(answer);

  }

  // 4개로 이어진 테트로미노에서 최댓값을 찾는 함수
  static void dfs(int depth, int[] now) {
    if (depth == 4) {
      int tempSum = 0;
      for (int i : arr) {
        tempSum += i;
      }
      answer = Math.max(answer, tempSum);
      return;
    }

    int x = now[0];
    int y = now[1];
    arr[depth] = input[x][y];

    for (int i = 0; i < 4; i++) {
      int moveX = x + dx[i];
      int moveY = y + dy[i];

      if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && check[moveX][moveY] == 0) {
        check[moveX][moveY] = 1;
        dfs(depth + 1, new int[]{moveX, moveY});
        check[moveX][moveY] = 0;
      }
    }
  }

  // ㅗ ㅓ ㅏ ㅜ 모형의 최댓값을 찾는 함수
  static void pinkShapeCheck(int[] now) {
    int x = now[0];
    int y = now[1];

    for (int[] p1 : pinkShape) {
      int tempSum = input[x][y];

      for (int i = 0; i < 3; i++) {
        int moveX = x + dx[p1[i]];
        int moveY = y + dy[p1[i]];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
          tempSum += input[moveX][moveY];
        } else {
          tempSum = 0;
          break;
        }
      }

      answer = Math.max(answer, tempSum);
    }
  }

}